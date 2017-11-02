import sbt._
import sbt.Keys._
import sbt.plugins.JvmPlugin

object MyPlugin extends AutoPlugin {

	override val requires = JvmPlugin
	override val trigger = AllRequirements


	object autoImport {
		val buildNumber = settingKey[String]("The build number parsed from BUILD_NUMBER environment variable")
	}

	import autoImport._

	override def projectSettings : Seq[Setting[_]] = Seq(
		buildNumber := sys.env.getOrElse("BUILD_NUMBER", "0-SNAPSHOT"),
		version := "1." + buildNumber.value
	) ++ addCommandAlias("validate", "; clean ; compile ; scalafmt::test ; test")
}