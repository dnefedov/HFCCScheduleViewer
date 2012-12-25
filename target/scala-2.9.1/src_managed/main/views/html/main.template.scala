
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
        <title>"""),_display_(Seq[Any](/*8.17*/Messages("app.title"))),format.raw/*8.38*/(""" - """),_display_(Seq[Any](/*8.42*/title)),format.raw/*8.47*/("""</title>


        <link rel="stylesheet"
              media="screen"
              href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">

        <script src="http://code.jquery.com/jquery-1.8.3.js"
                type="text/javascript"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"
                type="text/javascript"></script>

        <script>
            $(document).ready(function() """),format.raw("""{"""),format.raw/*21.43*/("""
                $(".more-info-link").click(function() """),format.raw("""{"""),format.raw/*22.56*/("""
                    $("#details").load("details?broadcast=" + $(this).attr("id"));
                    $("#details").dialog();
                """),format.raw("""}"""),format.raw/*25.18*/(""");
            """),format.raw("""}"""),format.raw/*26.14*/(""");
        </script>


        <link rel="stylesheet" media="screen"
              href=""""),_display_(Seq[Any](/*31.22*/routes/*31.28*/.Assets.at("stylesheets/main.min.css"))),format.raw/*31.66*/("""">
        <link rel="shortcut icon" type="image/png"
              href=""""),_display_(Seq[Any](/*33.22*/routes/*33.28*/.Assets.at("images/favicon.png"))),format.raw/*33.60*/("""">

    </head>

    <body>
        """),_display_(Seq[Any](/*38.10*/content)),format.raw/*38.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 00:08:32 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/main.scala.html
                    HASH: 2a8deb062226ab325c11cf9c91faf50592e58d75
                    MATRIX: 509->1|616->31|780->160|822->181|861->185|887->190|1372->628|1475->684|1667->829|1730->845|1856->935|1871->941|1931->979|2042->1054|2057->1060|2111->1092|2184->1129|2213->1136
                    LINES: 19->1|22->1|29->8|29->8|29->8|29->8|42->21|43->22|46->25|47->26|52->31|52->31|52->31|54->33|54->33|54->33|59->38|59->38
                    -- GENERATED --
                */
            