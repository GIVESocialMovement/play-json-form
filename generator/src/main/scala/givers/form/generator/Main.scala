package givers.form.generator

import java.io.PrintWriter
import java.nio.file.{Files, Paths}
import treehugger.forest._
import definitions._
import treehuggerDSL._

object Main {
  val PATH = Paths.get("src/main/scala/givers/form/generated")

  def generateObjectMappingClassDef(size: Int): ClassDef = {
    val objectType = TYPEVAR("T")
    val parameterTypes = 0.until(size).map { index => TYPEVAR(s"A$index") }

    val fields = parameterTypes.zipWithIndex.map { case (tp, index) =>
      PARAM(s"f$index", s"Field[${tp.name}]")
    }

    val params =
      Seq(
        PARAM("apply", s"(${parameterTypes.map(_.name).mkString(", ")}) => T"),
        PARAM(
          "unapply",
          if (fields.size == 1) {
            s"T => Option[(${parameterTypes.head.name})]"
          } else {
            s"T => Option[(${parameterTypes.map(_.name).mkString(", ")})]"
          }
        )
      ) ++ fields

    val body = BLOCK(
      VAL("fields").:=(REF("Seq").APPLY(fields.map { f => REF(f.name)})),
      DEF("bind", s"Try[${objectType.name}]")
        .withParams(PARAM("value", "JsValue").tree)
        .:=(
          BLOCK(
            REF("ObjectMapping")
              .DOT("convert")
              .APPLY(REF("value"), REF("fields"))
              .DOT("map")
              .APPLY(
                LAMBDA(PARAM("items").tree).==>(REF("apply").APPLY(
                  parameterTypes.zipWithIndex.map { case (tp, index) =>
                    REF(s"items($index).asInstanceOf[${tp.name}]")
                  }
                ))
              )
          )
        ),
      DEF("unbind", "JsValue")
        .withParams(PARAM("value", s"${objectType.name}").tree)
        .:=(
          BLOCK(
            VAL("values").:=(REF("unapply").APPLY(REF("value")).DOT("get")),
            REF("Json").DOT("obj").APPLY(
              fields.zipWithIndex.map { case (field, index) =>
                TUPLE(
                  REF(field.name).DOT("key"),
                  if (fields.size == 1) {
                    REF(field.name).DOT("mapping").DOT("unbind").APPLY(REF("values"))
                  } else {
                    REF(field.name).DOT("mapping").DOT("unbind").APPLY(REF("values").DOT(s"_${index + 1}"))
                  }
                )
              }
            )
          )
        )
    )

    CLASSDEF(s"ObjectMapping$size")
      .withTypeParams(Seq(objectType) ++ parameterTypes)
      .withParams(params.map(_.tree))
      .withParents(s"ObjectMapping[${objectType.name}]")
      .:=(body)
  }

  def generateObjFunDef(size: Int) = {
    val objectType = TYPEVAR("T")
    val parameterTypes = 0.until(size).map { index => TYPEVAR(s"A$index") }

    val fields = parameterTypes.zipWithIndex.map { case (tp, index) =>
      PARAM(s"f$index", s"(String, Mapping[${tp.name}])")
    }

    val funParams = Seq(
      PARAM("apply", s"(${parameterTypes.map(_.name).mkString(", ")}) => T"),
      PARAM(
        "unapply",
        if (fields.size == 1) {
          s"T => Option[(${parameterTypes.head.name})]"
        } else {
          s"T => Option[(${parameterTypes.map(_.name).mkString(", ")})]"
        }
      )
    )

    Seq(
      DEF("obj", s"ObjectMapping[${objectType.name}]")
        .withTypeParams(Seq(objectType) ++ parameterTypes)
        .withParams((funParams ++ fields).map(_.tree))
        .:=(BLOCK(
          NEW(
            s"ObjectMapping$size",
            funParams.map { p => REF(p.name) } ++ fields.map { p => REF("Field").APPLY(REF(p.name)) }:_*
          )
        )),
      DEF("mapping", s"ObjectMapping[${objectType.name}]")
        // TODO(tanin): Add @deprecated when the time is right.
//        .withAnnots(ANNOT("deprecated", LIT("Please use `obj` instead. If you are constructing a form, you can also use `Form.apply` directly.")))
        .withTypeParams(Seq(objectType) ++ parameterTypes)
        .withParams(fields.map(_.tree))
        .withParams(funParams.head.tree)
        .withParams(funParams(1).tree)
        .:=(BLOCK(
          NEW(
            s"ObjectMapping$size",
            funParams.map { p => REF(p.name) } ++ fields.map { p => REF("Field").APPLY(REF(p.name)) }:_*
          )
        ))
    )
  }

  def generateFormFunDef(size: Int) = {
    val objectType = TYPEVAR("T")
    val parameterTypes = 0.until(size).map { index => TYPEVAR(s"A$index") }

    val fields = parameterTypes.zipWithIndex.map { case (tp, index) =>
      PARAM(s"f$index", s"(String, Mapping[${tp.name}])")
    }

    val funParams = Seq(
      PARAM("apply", s"(${parameterTypes.map(_.name).mkString(", ")}) => T"),
      PARAM(
        "unapply",
        if (fields.size == 1) {
          s"T => Option[(${parameterTypes.head.name})]"
        } else {
          s"T => Option[(${parameterTypes.map(_.name).mkString(", ")})]"
        }
      )
    )

    DEF("apply", s"Form[${objectType.name}]")
      .withTypeParams(Seq(objectType) ++ parameterTypes)
      .withParams((funParams ++ fields).map(_.tree))
      .:=(BLOCK(
        NEW(
          "Form",
          REF(s"ObjectMappings").DOT("obj").APPLY(
            (funParams ++ fields).map { p => REF(p.name) }
          )
        )
      ))
  }

  def write(fileName: String, content: String) = {
    val pw = new PrintWriter(PATH.resolve(fileName).toFile)
    pw.write(content)
    pw.close()
  }

  def main(args: Array[String]): Unit = {
    Files.createDirectories(PATH)

    val objectMappingClassDefs = 1.to(22).map(generateObjectMappingClassDef)
    val objectMappingImports = Seq(
      IMPORT("givers.form.Mapping.Field"),
      IMPORT("givers.form.ObjectMapping"),
      IMPORT("play.api.libs.json.JsValue"),
      IMPORT("play.api.libs.json.JsObject"),
      IMPORT("play.api.libs.json.Json"),
      IMPORT("scala.util.Try")
    )

    write(
      "ObjectMapping.scala",
      treeToString(
        BLOCK(objectMappingImports ++ objectMappingClassDefs)
          .inPackage("givers.form.generated")
      )
    )

    val objFunDefs = 1.to(22).map(generateObjFunDef)
    val objImports = Seq(
      IMPORT("givers.form.Mapping.Field"),
      IMPORT("givers.form.ObjectMapping"),
      IMPORT("givers.form.Mapping")
    )

    write(
      "ObjectMappings.scala",
      treeToString(
        BLOCK(
          objImports ++
            Seq(
              TRAITDEF("ObjectMappings").:=(BLOCK(objFunDefs.flatten)),
              OBJECTDEF("ObjectMappings").withParents("ObjectMappings").tree)
        )
        .inPackage("givers.form.generated"))
    )

    val formFunDefs = 1.to(22).map(generateFormFunDef)
    val formImports = Seq(
      IMPORT("givers.form.Form"),
      IMPORT("givers.form.Mapping")
    )

    write(
      "Forms.scala",
      treeToString(
        BLOCK(
          formImports ++
            Seq(TRAITDEF("Forms").:=(BLOCK(formFunDefs)))
        )
        .inPackage("givers.form.generated"))
    )
  }
}
