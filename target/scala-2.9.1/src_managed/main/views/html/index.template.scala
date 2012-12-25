
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main(message)/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    
    """),_display_(Seq[Any](/*5.6*/play20/*5.12*/.welcome(message))),format.raw/*5.29*/("""

""")))})))}
    }
    
    def render(message:String) = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 14:36:33 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/index.scala.html
                    HASH: a90d4c5e6e51813515af0dcc246646cf7d740f8a
                    MATRIX: 505->1|599->18|636->21|657->34|696->36|741->47|755->53|793->70
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5
                    -- GENERATED --
                */
            