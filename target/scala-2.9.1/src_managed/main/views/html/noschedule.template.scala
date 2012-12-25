
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
object noschedule extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<h1>"""),_display_(Seq[Any](/*1.6*/Messages("app.title"))),format.raw/*1.27*/("""</h1>

<p>
    In order to view and browse a schedule,
    please
    <a href=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Application.upload.url)),format.raw/*6.44*/("""">upload schedule data</a>.
</p>
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 14:49:00 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/noschedule.scala.html
                    HASH: 4dcca1eaaf888855bb27466322d28bd79309b9d8
                    MATRIX: 574->0|613->5|655->26|770->106|784->112|828->135
                    LINES: 22->1|22->1|22->1|27->6|27->6|27->6
                    -- GENERATED --
                */
            