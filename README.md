JSON Form for Playframework
============================

[![CircleCI](https://circleci.com/gh/tanin47/play-json-form/tree/master.svg?style=shield)](https://circleci.com/gh/GIVESocialMovement/play-json-form/tree/master)

This is a replacement of [Play's form submission and validation](https://www.playframework.com/documentation/2.8.x/ScalaForms).

The library is inherently compatible with JSON, as in the conversion between `JsValue` and a case class is symmetric.
In contrast, [The standard Play's form library](https://www.playframework.com/documentation/2.6.x/ScalaForms) doesn't hold the symmetry property when converting nested objects and arrays.


### But why is JSON compatibility important?

At [GIVE.asia](https://give.asia), we serialize `play.api.data.Form` to json and pass it to a Vue component.

Since `play.api.data.Form` didn't support converting to JSON, we converted its member `data: Map[String, String]` to JSON instead.

With `Map[String, String]`, a JSON `{ "images": ["test.png"] }` would eventually be converted to `{ "images[0]": "test.png" }`.
And it became tricky to modify our Vue components to handle this kind of array encoding.

Please note that converting JSON into case class (using `bindFromRequest`) works fine.
In a rare occasion that you might have a field that contains `[..]`, that might cause an issue.

Please see this blog post, which also explains how we build a form, for more context: https://give.engineering/2018/09/15/form-submission-and-validation-in-playframework.html


### Why can't we modify `play.api.data.Form` to be fully compatible with JSON?

`Map[String, String]` isn't powerful enough to support `JsObject`, and it is defined in many critical places.
For example, `Mapping.unbind` returns `Map[String, String]`.

Since `JsObject` is powerful enough to support `Map[String, String]`, one good way to improve Play's form with
backward compatibility is to make `Mapping.unbind` return `JsObject` and provides a thin layer that converts
`JsObject` to `Map[String, String]`.


Advanced and experimental features
-----------------------------------

### List all possible validation errors

At GIVE.asia, we have more than 20 forms, each of which has several fields. It's tedious to ensure every error message is translated. Previously, what we did is to writing tests on controllers where we send requests with invalid input. It was odd to test the whole path of HTTP request in order to verify that our error messages are translated. So, we've come up with a new way of ensuring every error message is translated.

`Form.getAllErrors()` conveniently generates all possible validation errors. However, when building a `Mapping`, we need to properly code all the possible validation errors. For example:

```
new Mapping[String] {
  addError("error.invalid")

  def bind(value: JsLookupResult, context: BindContext): Try[String] = {
    // Do something
    Failure(Mapping.error("error.invalid"))
  }
  
  def unbind(value: String, context: UnbindContext): JsValue = {
    // Do something
  }
}
```

The work is still tedious but much less tedious than without one. We are open to hear about a better design.


### Map a value that depends on another value

At GIVE.asia, we have the use case where we want to convert an amount from `String` (as in `1,000.53` or `1,000`) to cents, which is `Long`. However, we can't convert it unless we know the currency first. Because, for a two-decimal currency, we will multiply the value by 100. But, for a zero-decimal currency, we won't. It follows [the guideline by Stripe](https://stripe.com/docs/currencies#zero-decimal).

One simple solution is to make 2 forms. The first form processes the currency. Then, we use the currency to create the second form. That's clunky.

Our solution is that we offer `BindContext` which allows `Mapping` to access its context, or, in other words, the values of its peers. For example:

```
new Mapping[String] {
  def bind(value: JsLookupResult, context: BindContext): Try[Long] = {
    context.get("currency") match {
      case Some(currency: Currency) =>
        if (currency.isZeroDecimal) {
          Success(convertAmountWithZeroDecimal(value))
        } else {
          Success(convertAmountWithTwoDecimal(value))
        }
      // The currency field might fail to be parsed. In this case, this mapping is not applicable.
      case _ => Failure(NotApplicationException) 
    }
  }
  
  def unbind(value: String, context: UnbindContext): JsValue = {
    // Do something
  }
}
```

The design is a little awkward. But it hides complexity from the user. We are open to hear about a better design.


Important compatibility notes
------------------------------

Since we aim to facilitate the migration from Play's Form, there are certain counter-intuitive behaviours that should be highlighted.

The below are the behaviours that you need to enable explicitly:

* Set `coerceToString` to `true` in order to make `text` convert any type (e.g. `JsNumber`) to `String`.
* Set `translateNoneToEmpty` to `true` in order to make `seq` accept the absence of the value as `Seq.empty` [ref](https://github.com/playframework/playframework/blob/4021237f91b0e2fd488a07a845e7c19ada5d1be7/framework/src/play/src/main/scala/play/api/data/Form.scala#L683).
* Set `translateEmptyStringToNone` to `true` in order to make `opt(text)` translate an empty string to `None` [ref](https://github.com/playframework/playframework/blob/4021237f91b0e2fd488a07a845e7c19ada5d1be7/framework/src/play/src/main/scala/play/api/data/Form.scala#L813).
* Set `translateAbsenceToFalse` to `true` in order to make `boolean` translate the absence of the key as `false` [ref](https://github.com/playframework/playframework/blob/4021237f91b0e2fd488a07a845e7c19ada5d1be7/framework/src/play/src/main/scala/play/api/data/format/Format.scala#L181).

When migrating from Play's Form, you __should enable__ all of these flags to avoid surprises.

The below behaviours are enabled automatically because they are sensible. Here they are:

* `number` and `longNumber` accept both `JsString` and `JsNumber`.
* `boolean` accepts both `JsString` and `JsBoolean`.

Most of these behaviours stem from the fact that `JsObject` has more complex types while `Map[String, String]` doesn't.


Usage
------

Add the below line to your `build.sbt`:

```
libraryDependencies += "io.github.tanin47" %% "play-json-form" % "1.0.0"
```

The artifacts are hosted here: https://bintray.com/givers/maven/play-json-form


Example
--------

You can see a fully working example in the folder `example-project`.

Making a form:

```
import givers.form.Form
import givers.form.Mappings._

case class Obj(a: String, b: Int)

val form = Form(
  mapping(
    "a" -> text(allowEmpty = false),
    "b" -> number()
  )(TestObj.apply)(TestObj.unapply)
)

// We also have a slightly shorter API:
val form2 = Form(
  TestObj.apply,
  TestObj.unapply,
  "a" -> text(allowEmpty = false),
  "b" -> number()
)

form.bindFromRequest()(req)
```

Building a Mapping based on another Mapping:

```
import givers.form.Mappings

object Currency extends Enumeration {
  val SGD, USD, EUR = Value
}

val currency = Mappings.text(allowEmpty = false).transform[Currency.Value](
  bind = { s =>
    try {
      Success(Currency.withName(s.toUpperCase))
    } catch {
      case _: Exception => Failure(Mapping.error("error.invalid", s))
    }
  },
  unbind = _.toString
)
```


Extend a Mapping with an additional validation:

```
import givers.form.Mappings

val email = Mappings.text.validate("error.email") { s => s.nonEmpty && s.contains("@") }
```

Please see all predefined mappings in `givers.form.Mappings`.

If there are more than 22 parameters, you can use the type-less version of it:

```
val form = Form[TestObj](
  "validation.form",
  Seq(
    "a" -> Mappings.text(allowEmpty = false),
    "b" -> Mappings.number()
  )
)
```


Develop
--------

1. Run `sbt generator/run` in order to generate the classes in `givers.form.generated`.
2. Run `sbt test` to run all tests
3. Run `sbt clean publishSigned` to publish
