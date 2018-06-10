
lazy val bundler = (project in file("."))
  .settings(
    name := "webpack-dev-server",
    scalaVersion := "2.12.4",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.2",
      "com.github.japgolly.scalajs-react" %%% "core" % "1.2.0",
      "com.github.japgolly.scalajs-react" %%% "extra" % "1.2.0",
    ),
    webpackConfigFile := Some(baseDirectory.value / "webpack.config.js"),
    (npmDevDependencies in Compile) ++= Seq(
      "html-webpack-plugin" -> "3.0.6",
      "react" -> "16.4.0",
      "react-dom" -> "16.4.0",
      "reactstrap" -> "6.1.0"
    ),
    webpackDevServerPort := 7357,
	version in webpack := "4.1.1",
	version in startWebpackDevServer := "3.1.1"
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)











