libraryDependencies ++= Seq(Dependencies.akkaHttp, Dependencies.scalactic, Dependencies.scalaTest)

enablePlugins(BuildInfoPlugin, MyPlugin)

buildInfoOptions += BuildInfoOption.ToJson

buildInfoKeys += BuildInfoKey.action("buildTime") {
	System.currentTimeMillis()

}