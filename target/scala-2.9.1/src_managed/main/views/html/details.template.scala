
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
object details extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.radio.Schedule,models.radio.Broadcast,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(schedule: models.radio.Schedule, broadcast: models.radio.Broadcast):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.70*/("""

<table>

    <thead>

        <tr>
            <th rowspan="2">
                <a class="sort" href="sort=station">Station</a>
            </th>
            <th rowspan="2">
                <a class="sort" href="sort=country">Country</a>
            </th>

            <th colspan="2">Date</th>

            <th rowspan="2">Days of Week</th>

            <th colspan="2">Time</th>

            <th rowspan="2">
                <a class="sort" href="sort=frequency">Frequency</a>
            </th>

            <th rowspan="2">
                <a class="sort" href="sort=languages">Languages</a>
            </th>

            <th rowspan="2">Target Zones</th>

            <th rowspan="2">
                <a class="sort" href="sort=power">Power</a>
            </th>
            <th rowspan="2">
                <a class="sort" href="sort=modulation">Modulation</a>
            </th>
            <th rowspan="2">
                <a class="sort" href="sort=azimuth">Azimuth</a>
            </th>

            <th rowspan="2">
                <a class="sort" href="sort=note">Note</a>
            </th>

            <th colspan="4">Location</th>
        </tr>

        <tr>
            <th>
                <a class="sort" href="sort=startdate">Start</a>
            </th>
            <th>
                <a class="sort" href="sort=enddate">End</a>
            </th>

            <th>
                <a class="sort" href="sort=starttime">Start</a>
            </th>
            <th>
                <a class="sort" href="sort=endtime">End</a>
            </th>

            <th>
                <a class="sort" href="sort=location">Name</a>
            </th>
            <th>
                <a class="sort" href="sort=locationcountry">Country</a>
            </th>
            <th>Longitude</th>
            <th>Latitude</th>
        </tr>

    </thead>

    <tbody>

            <tr>
                <td class="station">
                    <a class="search" href="station="""),_display_(Seq[Any](/*79.54*/broadcast/*79.63*/.stationId)),format.raw/*79.73*/("""">
                        """),_display_(Seq[Any](/*80.26*/schedule/*80.34*/.stations(broadcast.stationId).name)),format.raw/*80.69*/("""
                    </a>
                </td>
                <td class="country">
                    <a class="search" href="country="""),_display_(Seq[Any](/*84.54*/broadcast/*84.63*/.countryId)),format.raw/*84.73*/("""">
                        """),_display_(Seq[Any](/*85.26*/schedule/*85.34*/.countries(broadcast.countryId).name)),format.raw/*85.70*/("""
                    </a>
                </td>

                <td class="date">
                    <a class="search" href="startdate="""),_display_(Seq[Any](/*90.56*/broadcast/*90.65*/.startDateText)),format.raw/*90.79*/("""">
                        """),_display_(Seq[Any](/*91.26*/broadcast/*91.35*/.startDateText)),format.raw/*91.49*/("""
                    </a>
                </td>
                <td class="date">
                    <a class="search" href="enddate="""),_display_(Seq[Any](/*95.54*/broadcast/*95.63*/.endDateText)),format.raw/*95.75*/("""">
                        """),_display_(Seq[Any](/*96.26*/broadcast/*96.35*/.endDateText)),format.raw/*96.47*/("""
                    </a>
                </td>

                <td class="days">"""),_display_(Seq[Any](/*100.35*/broadcast/*100.44*/.daysOfWeek)),format.raw/*100.55*/("""</td>

                <td class="time">
                    <a class="search" href="starttime="""),_display_(Seq[Any](/*103.56*/broadcast/*103.65*/.startTimeText)),format.raw/*103.79*/("""">
                        """),_display_(Seq[Any](/*104.26*/broadcast/*104.35*/.startTimeText)),format.raw/*104.49*/("""
                    </a>
                </td>
                <td class="time">
                    <a class="search" href="endtime="""),_display_(Seq[Any](/*108.54*/broadcast/*108.63*/.endTimeText)),format.raw/*108.75*/("""">
                        """),_display_(Seq[Any](/*109.26*/broadcast/*109.35*/.endTimeText)),format.raw/*109.47*/("""
                    </a>
                </td>

                <td>
                    <a class="search" href="frequency="""),_display_(Seq[Any](/*114.56*/broadcast/*114.65*/.frequency)),format.raw/*114.75*/("""">
                        """),_display_(Seq[Any](/*115.26*/broadcast/*115.35*/.frequency)),format.raw/*115.45*/("""
                    </a>
                </td>

                <td class="langs">
                    <a class="search" href="languages="""),_display_(Seq[Any](/*120.56*/broadcast/*120.65*/.languages)),format.raw/*120.75*/("""">
                        """),_display_(Seq[Any](/*121.26*/broadcast/*121.35*/.languages)),format.raw/*121.45*/("""
                    </a>
                </td>

                <td class="target">"""),_display_(Seq[Any](/*125.37*/broadcast/*125.46*/.targetZones)),format.raw/*125.58*/("""</td>

                <td>"""),_display_(Seq[Any](/*127.22*/broadcast/*127.31*/.power)),format.raw/*127.37*/("""</td>
                <td>"""),_display_(Seq[Any](/*128.22*/broadcast/*128.31*/.modulation)),format.raw/*128.42*/("""</td>
                <td>"""),_display_(Seq[Any](/*129.22*/(broadcast.azimuth))),format.raw/*129.41*/("""°</td>

                <td class="note">"""),_display_(Seq[Any](/*131.35*/broadcast/*131.44*/.note)),format.raw/*131.49*/("""</td>

                <td class="location">
                    <a class="search" href="location="""),_display_(Seq[Any](/*134.55*/broadcast/*134.64*/.locationId)),format.raw/*134.75*/("""">
                        """),_display_(Seq[Any](/*135.26*/schedule/*135.34*/.locations(broadcast.locationId).name)),format.raw/*135.71*/("""
                    </a>
                </td>
                <td class="country">
                    <a class="search"
                        href="locationcountry="""),_display_(Seq[Any](/*140.48*/schedule/*140.56*/.locations(broadcast.locationId).countryId)),format.raw/*140.98*/("""">
                        """),_display_(Seq[Any](/*141.26*/{
                        val location = schedule.locations(broadcast.locationId);
                        schedule.countries(location.countryId).name
                        })),format.raw/*144.26*/("""
                    </a>
                </td>
                <td>"""),_display_(Seq[Any](/*147.22*/schedule/*147.30*/.locations(broadcast.locationId).longitude)),format.raw/*147.72*/("""</td>
                <td>"""),_display_(Seq[Any](/*148.22*/schedule/*148.30*/.locations(broadcast.locationId).latitude)),format.raw/*148.71*/("""</td>
            </tr>

    </tbody>

</table>
"""))}
    }
    
    def render(schedule:models.radio.Schedule,broadcast:models.radio.Broadcast) = apply(schedule,broadcast)
    
    def f:((models.radio.Schedule,models.radio.Broadcast) => play.api.templates.Html) = (schedule,broadcast) => apply(schedule,broadcast)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 24 17:25:01 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/details.scala.html
                    HASH: a9c3f84a0f7ee9d15e289fb0d9087ef0977b5b21
                    MATRIX: 545->1|690->69|2706->2049|2724->2058|2756->2068|2820->2096|2837->2104|2894->2139|3068->2277|3086->2286|3118->2296|3182->2324|3199->2332|3257->2368|3431->2506|3449->2515|3485->2529|3549->2557|3567->2566|3603->2580|3774->2715|3792->2724|3826->2736|3890->2764|3908->2773|3942->2785|4062->2868|4081->2877|4115->2888|4248->2984|4267->2993|4304->3007|4369->3035|4388->3044|4425->3058|4597->3193|4616->3202|4651->3214|4716->3242|4735->3251|4770->3263|4932->3388|4951->3397|4984->3407|5049->3435|5068->3444|5101->3454|5277->3593|5296->3602|5329->3612|5394->3640|5413->3649|5446->3659|5568->3744|5587->3753|5622->3765|5687->3793|5706->3802|5735->3808|5799->3835|5818->3844|5852->3855|5916->3882|5958->3901|6037->3943|6056->3952|6084->3957|6220->4056|6239->4065|6273->4076|6338->4104|6356->4112|6416->4149|6623->4319|6641->4327|6706->4369|6771->4397|6970->4573|7076->4642|7094->4650|7159->4692|7223->4719|7241->4727|7305->4768
                    LINES: 19->1|22->1|100->79|100->79|100->79|101->80|101->80|101->80|105->84|105->84|105->84|106->85|106->85|106->85|111->90|111->90|111->90|112->91|112->91|112->91|116->95|116->95|116->95|117->96|117->96|117->96|121->100|121->100|121->100|124->103|124->103|124->103|125->104|125->104|125->104|129->108|129->108|129->108|130->109|130->109|130->109|135->114|135->114|135->114|136->115|136->115|136->115|141->120|141->120|141->120|142->121|142->121|142->121|146->125|146->125|146->125|148->127|148->127|148->127|149->128|149->128|149->128|150->129|150->129|152->131|152->131|152->131|155->134|155->134|155->134|156->135|156->135|156->135|161->140|161->140|161->140|162->141|165->144|168->147|168->147|168->147|169->148|169->148|169->148
                    -- GENERATED --
                */
            