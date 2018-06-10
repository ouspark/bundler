import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, Resolution, Router, RouterConfigDsl, RouterCtl}
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.ScalaComponent
import module.reactstrap.Nav

object AppRouter {

  sealed trait Loc
  case object Home extends Loc

  object HomePage {

    val component = ScalaComponent.builder
      .static("Home Page")(

        <.div(
          "Scalajs React Home Page")
      )
      .build

    def apply() = component()
  }

  def layout(c: RouterCtl[Loc], r: Resolution[Loc]) =
    <.div(
      r.render()
    )

  val config = RouterConfigDsl[Loc].buildConfig { dsl =>
    import dsl._
    (trimSlashes
      | staticRoute(root, Home) ~> render(HomePage())
      )
      .notFound(redirectToPage(Home)(Redirect.Replace))
      .renderWith(layout)
  }

  val baseUrl = BaseUrl.fromWindowOrigin
  val router = Router(baseUrl, config)


}
