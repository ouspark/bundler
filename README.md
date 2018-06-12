# bundler

Test project for [scalajs-bundler](https://github.com/scalacenter/scalajs-bundler)

##### Take advantage of [scalajs-react-components](https://github.com/chandu0101/scalajs-react-components) to use a whole bunch of Components from JavaScript word(wrapped by scalajs facades or [scalajs-react](https://github.com/japgolly/scalajs-react) via [JsComponent](https://github.com/japgolly/scalajs-react/blob/master/doc/INTEROP.md))

Take `material-ui v0.20.0` as example, from scalajs-react JsComponent wrapper generation to how to use it... Learn things.

#### Project definition
* *app* - your own app project, use libraries defined/generated at *core* module.
* *core* - core library module, including CommonJS library helpers and your own written facades/libraries.
* *gen* - generate the CommonJS library corresponding scalajs-react JsComponent, via library rule definitions.
* *macros* - macros to leverage JsComponent transformation.

#### Run
> sbt  
> fastOptJS::webpack  
> app/compile:fastOptJS::startWebpackDevServer

#### Notes
*gen* generates the code into *core*'s src_managed folder  
webpack dev server version 3.1.1  
use scalajs-bundler LibraryOnly mode
