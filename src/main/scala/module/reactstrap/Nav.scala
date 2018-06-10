package module.reactstrap

import japgolly.scalajs.react.{Callback, Children}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

//@js.native
//trait Nav extends js.Object {
//  def tabs: Boolean = js.native
//}
//
//object Nav {
//  def apply(tabs: Boolean): Nav = {
//    js.Dynamic.literal(
//      tabs = tabs
//    ).asInstanceOf[Nav]
//  }
//}

import japgolly.scalajs.react.JsComponent
object Nav {

  @js.native
  @JSImport("reactstrap", "Nav")
  object RawNav extends js.Object

  @js.native
  trait Props extends js.Object {
    var tabs: Boolean = js.native
  }

  def props(tabs: Boolean): Props = {
    val p = (new js.Object).asInstanceOf[Props]
    p.tabs = tabs
    p
  }

  val component = JsComponent[Props, Children.Varargs, Null](RawNav)

  def apply(tabs: Boolean) = component

}


//object Nav {
//  case class NavProps(tabs: Boolean = false)
//
//  val Nav = ScalaComponent.builder[NavProps]("Nav")
//    .render_P(
//    )
//}