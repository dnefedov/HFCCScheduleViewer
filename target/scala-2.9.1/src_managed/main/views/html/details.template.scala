
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
object details extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.radio.Schedule,models.radio.Organization,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(schedule: models.radio.Schedule, organization: models.radio.Organization):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.76*/("""

<table class="details">

    <tbody>

        <tr>

            <th>Frequency Management Organization</th>

            <td>"""),_display_(Seq[Any](/*11.18*/organization/*11.30*/.name)),format.raw/*11.35*/("""</td>

        </tr>

        <tr>

            <th>Broadcasting Unions</th>

            <td>"""),_display_(Seq[Any](/*19.18*/organization/*19.30*/.unions)),format.raw/*19.37*/("""</td>

        </tr>

    </tbody>

</table>
"""))}
    }
    
    def render(schedule:models.radio.Schedule,organization:models.radio.Organization) = apply(schedule,organization)
    
    def f:((models.radio.Schedule,models.radio.Organization) => play.api.templates.Html) = (schedule,organization) => apply(schedule,organization)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 00:08:33 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/details.scala.html
                    HASH: aaac4ebba7c5777b6a2188400d32b78681d7da67
                    MATRIX: 548->1|699->75|862->202|883->214|910->219|1041->314|1062->326|1091->333
                    LINES: 19->1|22->1|32->11|32->11|32->11|40->19|40->19|40->19
                    -- GENERATED --
                */
            