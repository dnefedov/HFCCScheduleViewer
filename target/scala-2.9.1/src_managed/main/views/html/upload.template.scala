
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
object upload extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<h1>"""),_display_(Seq[Any](/*1.6*/Messages("app.title"))),format.raw/*1.27*/("""</h1>

<p>

To upload new data, please follow these steps:

    <ol>
    <li>
    download the file
<a href="http://www.hfcc.org/data/b12/b12allx2.zip">http://www.hfcc.org/data/b12/b12allx2.zip</a>
(located on
<a href="http://www.hfcc.org/data/">HFCC Web site</a>)
to your computer;
    </li>

    <li>
after that, upload it from your computer to this page using the controls below.
    </li>
</ol>
</p>

"""),_display_(Seq[Any](/*22.2*/helper/*22.8*/.form(action = routes.Application.uploaded, 'enctype -> "multipart/form-data")/*22.86*/ {_display_(Seq[Any](format.raw/*22.88*/("""

<input type="file" name="schedule"> <button type="submit">Upload File</button>

""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 18:11:16 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/upload.scala.html
                    HASH: 185f1048e7d6d2cd386bd9d685d9926f5661f71d
                    MATRIX: 570->0|609->5|651->26|1092->432|1106->438|1193->516|1233->518
                    LINES: 22->1|22->1|22->1|43->22|43->22|43->22|43->22
                    -- GENERATED --
                */
            