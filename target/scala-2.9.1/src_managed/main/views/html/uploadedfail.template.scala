
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
object uploadedfail extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<h1>"""),_display_(Seq[Any](/*1.6*/Messages("app.title"))),format.raw/*1.27*/("""</h1>

<p>
    Schedule data has <b>not</b> been successfully uploaded and parsed.
    Please try to
    <a href=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Application.upload.url)),format.raw/*6.44*/("""">upload schedule data</a> again.
</p>
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 18:11:16 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/uploadedfail.scala.html
                    HASH: 0d993ecf70e431ccbc67934332a1c3ec1f759105
                    MATRIX: 576->0|615->5|657->26|807->141|821->147|865->170
                    LINES: 22->1|22->1|22->1|27->6|27->6|27->6
                    -- GENERATED --
                */
            