package easyreading.app.init.services

import easyreading.app.constants.Const
import kotlin.io.path.Path


interface IFilePathService {

  val resources: String

  val configurationFile: String

  val fxCssFile: String


}

fun String.asPath() = Path(this)

fun String.andFileName(child: String) = this + Const.SLASH + child
fun String.andType(type: String) = this + Const.DOT + type


class DefaultFilePathService : IFilePathService {

  override val resources: String = "app/src/main/resources"

  override val configurationFile: String = resources.andFileName("config").andType("toml")

  override val fxCssFile: String = resources.andFileName("app").andType("css")
}