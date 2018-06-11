lazy val macros = project.in(file("macros"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    name := "scalajs-react-components-marcros",
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % "1.2.0",
      "com.github.japgolly.scalajs-react" %%% "extra" % "1.2.0",
      "org.scalatest"                     %%% "scalatest" % "3.0.4" % Test
    )
  )


lazy val gen = project.in(file("gen"))
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(commonSettings, npmGenSettings)
  .settings(
    name := "generator",
    organization := "com.akkoid",
    version in webpack := "4.1.1",
    libraryDependencies ++= Seq(
      "com.lihaoyi"   %% "ammonite-ops" % "1.0.1",
      "org.scalatest" %% "scalatest"    % "3.0.4" % Test
    )
  )


lazy val generateMui = TaskKey[Seq[File]]("generateMui")
lazy val core = project.in(file("core"))
  .dependsOn(macros)
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    generateMui := {
      val genDir = sourceManaged.value
      genDir.mkdirs()
      val res = runner.value.run(
        "com.akkoid.mui.MuiRunner",
        (fullClasspath in (gen, Runtime)).value.files,
        List(
          (npmUpdate in (gen, Compile)).value / "node_modules" / "@material-ui/core",
          sourceManaged.value / "main"
        ) map (_.absolutePath),
        streams.value.log
      )
      val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
      pathFinder.get.filter(_.getAbsolutePath.contains("material"))
    }
  )
  .settings(
    sourceGenerators in Compile += generateMui,
    mappings in (Compile, packageSrc) ++= {
      val sourceDir = (sourceManaged.value / "main").toPath
      def rel(f: File) = sourceDir.relativize(f.toPath).toString

      (managedSources in Compile).value map (s ⇒ s → rel(s))
    },
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core"        % "1.2.0" withSources (),
      "com.github.japgolly.scalajs-react" %%% "extra"       % "1.2.0" withSources (),
      "com.github.japgolly.scalacss"      %%% "core"        % "0.5.5" withSources (),
      "com.github.japgolly.scalacss"      %%% "ext-react"   % "0.5.5" withSources (),
      "org.scala-js"                      %%% "scalajs-dom" % "0.9.2" withSources (),
      "org.scalacheck"                    %%% "scalacheck"  % "1.13.5" % Test,
      "org.scalatest"                     %%% "scalatest"   % "3.0.4" % Test
    )
  )

lazy val app = (project in file("app"))
  .dependsOn(core)
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
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
      "@material-ui/core" -> "1.2.1",
      "material-ui" -> "0.20.0"
    ),
    webpackDevServerPort := 7357,
    version in webpack := "4.1.1",
    version in startWebpackDevServer := "3.1.1"
  )


lazy val bundler = project.in(file("."))
  .aggregate(macros, core, app)
  .settings(commonSettings)



lazy val commonSettings = Seq(
  scalaVersion := "2.12.4",
  version := "0.0.1-SNAPSHOT",
  name := "bundler",
  organization := "com.akkoid",
  mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE",
  scalacOptions ++= Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-unchecked", // Enable additional warnings where generated code depends on assumptions.
    "-language:implicitConversions", // Allow definition of implicit functions called views
    "-language:postfixOps",
    "-P:scalajs:sjsDefinedByDefault"
  ),
  unmanagedSourceDirectories.in(Compile) := Seq(scalaSource.in(Compile).value),
  unmanagedSourceDirectories.in(Test) := Seq(scalaSource.in(Test).value)
)

lazy val npmGenSettings = Seq(
  npmDependencies.in(Compile) := Seq(
    "@material-ui/core" -> "1.2.1"
  )
)













