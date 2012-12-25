
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object detailsnoschedule extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<p class="details-noschedule">
    <span>
        Schedule data has been removed,
        please
        <a href=""""),_display_(Seq[Any](/*5.19*/routes/*5.25*/.Application.upload.url)),format.raw/*5.48*/(""""
           target="_top">upload it</a> again.
    </span>
</p>
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 00:08:33 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/detailsnoschedule.scala.html
                    HASH: ae3b2348b2d2a4b5410d554e2bd7b91592cc0699
                    MATRIX: 581->0|731->115|745->121|789->144
                    LINES: 22->1|26->5|26->5|26->5
                    -- GENERATED --
                */
            