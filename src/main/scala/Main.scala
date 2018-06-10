import module.reactstrap.Nav
import org.scalajs.dom

object Main {

  def main(args: Array[String]): Unit = {

    if(dom.document.getElementById("root") == null) {
      val div = dom.document.createElement("div")
      div.id = "root"
      dom.document.body.appendChild(div)
    }

    AppRouter.router().renderIntoDOM(dom.document.getElementById("root"))
  }


}
