
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
object uploadedsuccess extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<h1>"""),_display_(Seq[Any](/*1.6*/Messages("app.title"))),format.raw/*1.27*/("""</h1>

<p>
    Schedule data has been successfully uploaded and parsed.
    You can now
    <a href=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Application.browse.url)),format.raw/*6.44*/("""">browse the schedule</a>.
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
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/uploadedsuccess.scala.html
                    HASH: f9dcb2e2406f39190b8276a75f40a5871f06223b
                    MATRIX: 579->0|618->5|660->26|797->128|811->134|855->157
                    LINES: 22->1|22->1|22->1|27->6|27->6|27->6
                    -- GENERATED --
                */
            