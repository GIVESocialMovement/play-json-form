JSON Form for Playframework
============================

[![CircleCI](https://circleci.com/gh/GIVESocialMovement/play-json-form/tree/master.svg?style=shield)](https://circleci.com/gh/GIVESocialMovement/play-json-form/tree/master)
[![codecov](https://codecov.io/gh/GIVESocialMovement/play-json-form/branch/master/graph/badge.svg)](https://codecov.io/gh/GIVESocialMovement/play-json-form)
[![Gitter chat](https://badges.gitter.im/GIVE-asia/gitter.png)](https://gitter.im/GIVE-asia/Lobby)

This is a replacement of [Play's form submission and validation](https://www.playframework.com/documentation/2.6.x/ScalaForms).
The API is similar enough that, hopefully, you can replace the import statements to make it work.

The library is inherently compatible with JSON, as in the conversion between `JsValue` and a case class is symmetric.
In contrast, [The standard Play's form library](https://www.playframework.com/documentation/2.6.x/ScalaForms) doesn't hold the symmetry property when converting nested objects and arrays.


### But why is JSON compatibility important?

At [GIVE.asia](https://give.asia), we serialize `play.api.data.Form` to json and pass it to a Vue component.

Since `play.api.data.Form` didn't support converting to JSON, we converted its member `data: Map[String, String]` to JSON instead.

With `Map[String, String]`, a JSON `{ "images": ["test.png"] }` would eventually be converted to `{ "images[0]": "test.png" }`.
And it became tricky to modify our Vue components to handle this kind of array encoding.

Please note that converting JSON into case class (using `bindFromRequest`) works fine.
In a rare occasion that you might have a field that contains `[..]`, there might cause an issue.

Please see this blog post, which also explains how we build a form, for more context: https://give.engineering/2018/09/15/form-submission-and-validation-in-playframework.html


### Why can't we modify `play.api.data.Form` to be fully compatible with JSON?

`Map[String, String]` isn't powerful enough to support `JsObject`, and it is defined in many critical places.
For example, `Mapping.unbind` returns `Map[String, String]`.

Since `JsObject` is powerful enough to support `Map[String, String]`, one good way to improve Play's form with
backward compatibility is to make `Mapping.unbind` return `JsObject` and provides a thin layer that converts
`JsObject` to `Map[String, String]`.


Important compatibility notes
------------------------------

Since we aim to be API compatible with Play's Form, there are certain counter-intuitive behaviours that should be highlighted.

The below are the behaviours that you need to enable explicitly:

* Set `translateNoneToEmpty` to `true` in order to make `seq` accept the absence of the value as `Seq.empty` [ref](https://github.com/playframework/playframework/blob/4021237f91b0e2fd488a07a845e7c19ada5d1be7/framework/src/play/src/main/scala/play/api/data/Form.scala#L683).
* Set `translateEmptyStringToNone` to `true` in order to make `optional(text)` translate an empty string to `None` [ref](https://github.com/playframework/playframework/blob/4021237f91b0e2fd488a07a845e7c19ada5d1be7/framework/src/play/src/main/scala/play/api/data/Form.scala#L813).
* Set `translateAbsenceToFalse` to `true` in order to make `boolean` translate the absence of the key as `false` [ref](https://github.com/playframework/playframework/blob/4021237f91b0e2fd488a07a845e7c19ada5d1be7/framework/src/play/src/main/scala/play/api/data/format/Format.scala#L181).

When migrating from Play's Form, you __should enable__ both of these flags to avoid surprises.

The below behaviours are enabled automatically because they are sensible. Here they are:

* `number` and `longNumber` accept both `JsString` and `JsNumber`.
* `boolean` accepts both `JsString` and `JsBoolean`.

Most of these behaviours stem from the fact that `JsObject` has more complex types while `Map[String, String]` doesn't.


Usage
------

Add the below line to your `build.sbt`:

```
resolvers += Resolver.bintrayRepo("givers", "maven")

addSbtPlugin("givers.form" %% "play-json-form" % "0.2.0")
```


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

Please all predefined mappings in `givers.form.Mappings`.


Develop
--------

1. Run `sbt generate/run` in order to generate the classes in `givers.form.generated`.
2. Run `sbt test` to run all tests
