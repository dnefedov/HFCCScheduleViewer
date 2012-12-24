
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
object browse extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[models.radio.Schedule,Map[String, Seq[String]],Form[models.radio.query.Query],Option[models.radio.query.SortKeys.Type],Option[Pager[models.radio.Broadcast]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(schedule: models.radio.Schedule,
  queryString: Map[String, Seq[String]],
  form: Form[models.radio.query.Query],
  sortKeysOption: Option[models.radio.query.SortKeys.Type],
  pagerOption: Option[Pager[models.radio.Broadcast]]):play.api.templates.Html = {
        _display_ {import models.radio.query.{SearchKey, SortKey, SortKeys}

def /*30.2*/attr/*30.6*/(name: String, default: Any, actual: Any):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*30.51*/("""

  """),_display_(Seq[Any](/*32.4*/if(actual != default)/*32.25*/ {_display_(Seq[Any](format.raw/*32.27*/("""

    """),_display_(Seq[Any](/*34.6*/toHtmlArgs(Map(Symbol(name) -> actual)))),format.raw/*34.45*/("""

  """)))})),format.raw/*36.4*/("""

""")))};def /*40.2*/attrs/*40.7*/(argsOption: Option[Map[Symbol, Any]]):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*40.49*/(""" """),_display_(Seq[Any](/*40.51*/argsOption match/*40.67*/ {/*42.5*/case Some(someArgs) =>/*42.27*/ {_display_(Seq[Any](format.raw/*42.29*/(""" """),_display_(Seq[Any](/*42.31*/toHtmlArgs(someArgs))),format.raw/*42.51*/(""" """)))}/*44.5*/case None =>/*44.17*/ {}})),format.raw/*46.4*/("""
""")))};def /*49.2*/caption/*49.9*/(
  title: String,
  rowspan: Int = 1,
  colspan: Int = 1,
  sortKeyNameOption: Option[SortKey.Name.Value] = None):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*53.60*/("""

  <th """),_display_(Seq[Any](/*55.8*/attr("rowspan", 1, rowspan))),format.raw/*55.35*/(""" """),_display_(Seq[Any](/*55.37*/attr("colspan", 1, colspan))),format.raw/*55.64*/(""">

    """),_display_(Seq[Any](/*57.6*/sortKeysOption match/*57.26*/ {/*59.7*/case Some(someSortKeys) =>/*59.33*/ {_display_(Seq[Any](format.raw/*59.35*/("""

        """),_display_(Seq[Any](/*61.10*/sortKeyNameOption match/*61.33*/ {/*63.11*/case Some(someSortKeyName) =>/*63.40*/ {_display_(Seq[Any](format.raw/*63.42*/("""

            <a class="sort" href=""""),_display_(Seq[Any](/*65.36*/sortUrl(someSortKeyName))),format.raw/*65.60*/("""">"""),_display_(Seq[Any](/*65.63*/Html(title))),format.raw/*65.74*/("""</a>

            """),_display_(Seq[Any](/*67.14*/if(someSortKeyName == someSortKeys.head.name)/*67.59*/ {_display_(Seq[Any](format.raw/*67.61*/("""
              <br>
              <a class="sort" href=""""),_display_(Seq[Any](/*69.38*/sortUrl(someSortKeyName, reverse = true))),format.raw/*69.78*/("""">
                """),_display_(Seq[Any](/*70.18*/if(someSortKeys.head.asc)/*70.43*/{_display_(Seq[Any](format.raw/*70.44*/("""&#x25B2;""")))}/*70.53*/else/*70.57*/{_display_(Seq[Any](format.raw/*70.58*/("""&#x25BC;""")))})),format.raw/*70.67*/("""
              </a>
            """)))})),format.raw/*72.14*/("""

          """)))}/*76.11*/case None =>/*76.23*/ {_display_(Seq[Any](format.raw/*76.25*/(""" """),_display_(Seq[Any](/*76.27*/Html(title))),format.raw/*76.38*/(""" """)))}})),format.raw/*78.10*/("""

      """)))}/*81.7*/case None =>/*81.19*/ {_display_(Seq[Any](format.raw/*81.21*/(""" """),_display_(Seq[Any](/*81.23*/Html(title))),format.raw/*81.34*/(""" """)))}})),format.raw/*82.6*/("""

  </th>

""")))};def /*88.2*/input/*88.7*/(
  placeholder: String,
  searchKey: SearchKey.Value,
  inputType: String = "text",
  colspan: Int = 1,
  argsOption: Option[Map[Symbol, Any]] = None):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*93.51*/("""

  <th """),_display_(Seq[Any](/*95.8*/attr("colspan", 1, colspan))),format.raw/*95.35*/(""">

    """),_display_(Seq[Any](/*97.6*/defining(form(searchKey.toString).value.getOrElse(""))/*97.60*/ { searchValue =>_display_(Seq[Any](format.raw/*97.77*/("""

      <input type=""""),_display_(Seq[Any](/*99.21*/inputType)),format.raw/*99.30*/(""""
             id=""""),_display_(Seq[Any](/*100.19*/searchKey/*100.28*/.toString)),format.raw/*100.37*/(""""
             name=""""),_display_(Seq[Any](/*101.21*/searchKey/*101.30*/.toString)),format.raw/*101.39*/("""" """),_display_(Seq[Any](/*101.42*/attrs(argsOption))),format.raw/*101.59*/("""
             placeholder=""""),_display_(Seq[Any](/*102.28*/if(searchValue.isEmpty)/*102.51*/{_display_(Seq[Any](_display_(Seq[Any](/*102.53*/placeholder))))}/*102.65*/else/*102.69*/{_display_(Seq[Any](_display_(Seq[Any](/*102.71*/searchValue))))})),format.raw/*102.83*/(""""
             value=""""),_display_(Seq[Any](/*103.22*/searchValue)),format.raw/*103.33*/(""""
             class=""""),_display_(Seq[Any](/*104.22*/if(form(searchKey.toString).hasErrors)/*104.60*/{_display_(Seq[Any](format.raw/*104.61*/("""error""")))})),format.raw/*104.67*/("""">
    """)))})),format.raw/*105.6*/("""

  </th>
""")))};def /*110.2*/data/*110.6*/(
  text: String,
  dataClass: String,
  searchKeyOption: Option[SearchKey.Value] = None):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*113.55*/("""

  <td class=""""),_display_(Seq[Any](/*115.15*/dataClass)),format.raw/*115.24*/("""">

    """),_display_(Seq[Any](/*117.6*/searchKeyOption match/*117.27*/ {/*119.7*/case Some(someSearchKey) =>/*119.34*/ {_display_(Seq[Any](format.raw/*119.36*/("""
        <a class="search" href=""""),_display_(Seq[Any](/*120.34*/url(someSearchKey.toString, text))),format.raw/*120.67*/("""">"""),_display_(Seq[Any](/*120.70*/Html(text))),format.raw/*120.80*/("""</a>
      """)))}/*123.7*/case None =>/*123.19*/ {_display_(Seq[Any](format.raw/*123.21*/(""" """),_display_(Seq[Any](/*123.23*/Html(text)))))}})),format.raw/*125.6*/("""

  </td>
""")))};def /*9.2*/url/*9.5*/(keyName: String, keyValue: String, keepPage: Boolean = false) = {{

  val queryStringWithNewKeyValue = queryString + (keyName -> Seq(keyValue))

  val updatedQueryString = if (keepPage)
    queryStringWithNewKeyValue
  else
    queryStringWithNewKeyValue - Pager.paramName

  UrlUtil.fullUrl(routes.Application.browse.url, updatedQueryString)

}};def /*22.2*/sortUrl/*22.9*/(sortKeyName: SortKey.Name.Value, reverse: Boolean = false) = {{

  url(
    SortKeys.paramName,
    SortKeys.prependAndFormat(sortKeysOption.get, sortKeyName, reverse))

}};
Seq[Any](format.raw/*5.54*/("""

"""),format.raw/*8.1*/("""
"""),format.raw/*20.2*/("""

"""),format.raw/*28.2*/("""

"""),format.raw/*38.2*/("""

"""),format.raw/*47.2*/("""

"""),format.raw/*86.2*/("""

"""),format.raw/*108.2*/("""

"""),format.raw/*128.2*/("""



<p style="float:right; margin-top:0">
    <a href="/upload">Upload new schedule data</a>
</p>

<h1>"""),_display_(Seq[Any](/*136.6*/Messages("app.title"))),format.raw/*136.27*/("""</h1>

<ul>
    <li>Click links in table header to sort data.</li>
    <li>Click triangle in table header to reverse sort order.</li>
    <li>Click links in data to search for similar data.</li>
</ul>

<p style="margin-bottom:1.67em">Times and dates are in UTC.</p>

"""),_display_(Seq[Any](/*146.2*/helper/*146.8*/.form(action = routes.Application.browse)/*146.49*/ {_display_(Seq[Any](format.raw/*146.51*/("""

<input type="hidden" id="sort" name="sort" value=""""),_display_(Seq[Any](/*148.52*/(form("sort").value.get))),format.raw/*148.76*/("""">

<table style="clear:both">

    <thead>

    <tr class="caption">
"""),_display_(Seq[Any](/*155.2*/caption(
  "Station",
  rowspan = 2,
  sortKeyNameOption = Some(SortKey.Name.StationName)))),format.raw/*158.54*/("""
"""),_display_(Seq[Any](/*159.2*/caption(
  "Country",
  rowspan = 2,
  sortKeyNameOption = Some(SortKey.Name.StationCountry)))),format.raw/*162.57*/("""

"""),_display_(Seq[Any](/*164.2*/caption("Date", colspan = 2))),format.raw/*164.30*/("""
"""),_display_(Seq[Any](/*165.2*/caption("Days<br>of<br>Week", rowspan = 3))),format.raw/*165.44*/("""
"""),_display_(Seq[Any](/*166.2*/caption("Time", colspan = 2))),format.raw/*166.30*/("""

"""),format.raw/*171.3*/("""
"""),_display_(Seq[Any](/*172.2*/caption(
  "Frequency",
  rowspan = 2,
  sortKeyNameOption = Some(SortKey.Name.Frequency)))),format.raw/*175.52*/("""

"""),_display_(Seq[Any](/*177.2*/caption(
  "Languages",
  rowspan = 2,
  sortKeyNameOption = Some(SortKey.Name.Languages)))),format.raw/*180.52*/("""

"""),_display_(Seq[Any](/*182.2*/caption("Target Zones", rowspan = 3))),format.raw/*182.38*/("""

"""),_display_(Seq[Any](/*184.2*/caption(
  "Power",
  rowspan = 3,
  sortKeyNameOption = Some(SortKey.Name.Power)))),format.raw/*187.48*/("""
"""),_display_(Seq[Any](/*188.2*/caption(
  "Modu&shy;lation",
  rowspan = 3,
  sortKeyNameOption = Some(SortKey.Name.Modulation)))),format.raw/*191.53*/("""
"""),_display_(Seq[Any](/*192.2*/caption(
  "Azi&shy;muth",
  rowspan = 3,
  sortKeyNameOption = Some(SortKey.Name.Azimuth)))),format.raw/*195.50*/("""

"""),_display_(Seq[Any](/*197.2*/caption(
  "Note",
  rowspan = 3,
  sortKeyNameOption = Some(SortKey.Name.Note)))),format.raw/*200.47*/("""

"""),_display_(Seq[Any](/*202.2*/caption("Location", colspan = 4))),format.raw/*202.34*/("""

"""),_display_(Seq[Any](/*204.2*/caption("More", rowspan = 3))),format.raw/*204.30*/("""
    </tr>

    <tr class="caption">
"""),_display_(Seq[Any](/*208.2*/caption("Start", sortKeyNameOption = Some(SortKey.Name.StartDate)))),format.raw/*208.68*/("""
"""),_display_(Seq[Any](/*209.2*/caption("End",   sortKeyNameOption = Some(SortKey.Name.EndDate)))),format.raw/*209.66*/("""

"""),_display_(Seq[Any](/*211.2*/caption("Start", sortKeyNameOption = Some(SortKey.Name.StartTime)))),format.raw/*211.68*/("""
"""),_display_(Seq[Any](/*212.2*/caption("End",   sortKeyNameOption = Some(SortKey.Name.EndTime)))),format.raw/*212.66*/("""

"""),_display_(Seq[Any](/*214.2*/caption("Name",    sortKeyNameOption = Some(SortKey.Name.LocationName)))),format.raw/*214.73*/("""
"""),_display_(Seq[Any](/*215.2*/caption("Country", sortKeyNameOption = Some(SortKey.Name.LocationCountry)))),format.raw/*215.76*/("""
"""),_display_(Seq[Any](/*216.2*/caption("Longi&shy;tude", rowspan = 2))),format.raw/*216.40*/("""
"""),_display_(Seq[Any](/*217.2*/caption("Lati&shy;tude",  rowspan = 2))),format.raw/*217.40*/("""
    </tr>



    <tr class="search">
"""),_display_(Seq[Any](/*223.2*/input("Station", SearchKey.StationName))),format.raw/*223.41*/("""
"""),_display_(Seq[Any](/*224.2*/input("Country", SearchKey.StationCountry))),format.raw/*224.44*/("""

"""),_display_(Seq[Any](/*226.2*/input("YYYY-MM-DD", SearchKey.Date, inputType = "date", colspan = 2))),format.raw/*226.70*/("""
"""),_display_(Seq[Any](/*227.2*/input("HH:MM",      SearchKey.Time, inputType = "time", colspan = 2))),format.raw/*227.70*/("""

"""),_display_(Seq[Any](/*229.2*/input(
  "Number",
  SearchKey.Frequency,
  inputType = "number",
  argsOption = Some(Map('min -> 2300, 'max -> 26100, 'step -> "1"))))),format.raw/*233.69*/("""

"""),_display_(Seq[Any](/*235.2*/input("Language", SearchKey.Languages))),format.raw/*235.40*/("""

"""),_display_(Seq[Any](/*237.2*/input("Location", SearchKey.LocationName))),format.raw/*237.43*/("""
"""),_display_(Seq[Any](/*238.2*/input("Country",  SearchKey.LocationCountry))),format.raw/*238.46*/("""
    </tr>

    <tr class="search">
        <th colspan="19">
            <button type="submit" class="search">Search</button>
        </th>
    </tr>
    <tr class="search">
        <th class="pager border-bottom" colspan="16">
"""),_display_(Seq[Any](/*248.2*/pagerOption match/*248.19*/ {/*249.3*/case Some(somePager) =>/*249.26*/ {_display_(Seq[Any](format.raw/*249.28*/("""
    """),_display_(Seq[Any](/*250.6*/views/*250.11*/.html.pager(somePager, routes.Application.browse.url, queryString))),format.raw/*250.77*/("""
  """)))}/*252.3*/case None =>/*252.15*/ {_display_(Seq[Any](format.raw/*252.17*/(""" """)))}})),format.raw/*253.2*/("""
        </th>
        <th class="border-bottom" colspan="3" style="text-align:right">
            <button type="reset" class="reset">Reset</button>
        </th>
    </tr>

    </thead>

    <tbody>

"""),_display_(Seq[Any](/*264.2*/if(form.hasErrors || form.hasGlobalErrors)/*264.44*/ {_display_(Seq[Any](format.raw/*264.46*/("""

<tr class="error">
    <td colspan="19">

There are some errors in query parameters:

<ul>

  """),_display_(Seq[Any](/*273.4*/if(form("date").hasErrors)/*273.30*/ {_display_(Seq[Any](format.raw/*273.32*/("""
    <li>Date should be in this format: YYYY-MM-DD.</li>
  """)))})),format.raw/*275.4*/("""

  """),_display_(Seq[Any](/*277.4*/if(form("time").hasErrors)/*277.30*/ {_display_(Seq[Any](format.raw/*277.32*/("""
    <li>Time should be in this format: HH-MM.</li>
  """)))})),format.raw/*279.4*/("""


  """),_display_(Seq[Any](/*282.4*/if(form("frequency").hasErrors)/*282.35*/ {_display_(Seq[Any](format.raw/*282.37*/("""
    <li>Frequency should be a number between 2300 and 26100.</li>
  """)))})),format.raw/*284.4*/("""


  """),_display_(Seq[Any](/*287.4*/if(form("sort").hasErrors)/*287.30*/ {_display_(Seq[Any](format.raw/*287.32*/("""
    <li>
        Sort parameter is invalid.
<a href=""""),_display_(Seq[Any](/*290.11*/url(SortKeys.paramName, SortKeys.defaultParamValue, keepPage = true))),format.raw/*290.79*/("""">
  Reset.
</a>
    </li>
  """)))})),format.raw/*294.4*/("""

  """),_display_(Seq[Any](/*296.4*/if(form("page").hasErrors)/*296.30*/ {_display_(Seq[Any](format.raw/*296.32*/("""
    <li>
        Page parameter should be a number greater than or equal to 1.
<a href=""""),_display_(Seq[Any](/*299.11*/url(Pager.paramName, Pager.defaultPageIndex.toString, keepPage = true))),format.raw/*299.81*/("""">
  Reset.
</a>
    </li>
  """)))})),format.raw/*303.4*/("""

</ul>

    </td>
</tr>

""")))}/*310.3*/else/*310.8*/{_display_(Seq[Any](format.raw/*310.9*/("""

"""),format.raw/*312.38*/("""

"""),_display_(Seq[Any](/*314.2*/if(pagerOption.get.items.isEmpty)/*314.35*/ {_display_(Seq[Any](format.raw/*314.37*/("""

<tr class="empty">
    <td colspan="19">
        No broadcasts match your search criteria.
    </td>
</tr>

""")))}/*322.3*/else/*322.8*/{_display_(Seq[Any](format.raw/*322.9*/("""

"""),_display_(Seq[Any](/*324.2*/pagerOption/*324.13*/.get.validPageItems.map/*324.36*/ { broadcast =>_display_(Seq[Any](format.raw/*324.51*/("""
    <tr class="data">
"""),_display_(Seq[Any](/*326.2*/data(
  schedule.stationName(broadcast.stationId),
  dataClass = "station-name",
  searchKeyOption = Some(SearchKey.StationName)))),format.raw/*329.49*/("""
"""),_display_(Seq[Any](/*330.2*/data(
  schedule.stationCountryName(broadcast.countryId),
  dataClass = "station-country",
  searchKeyOption = Some(SearchKey.StationCountry)))),format.raw/*333.52*/("""


"""),_display_(Seq[Any](/*336.2*/data(broadcast.startDateText, dataClass = "date start", searchKeyOption = Some(SearchKey.Date)))),format.raw/*336.97*/("""
"""),_display_(Seq[Any](/*337.2*/data(broadcast.endDateText,   dataClass = "date",       searchKeyOption = Some(SearchKey.Date)))),format.raw/*337.97*/("""

"""),_display_(Seq[Any](/*339.2*/data(broadcast.daysOfWeek, dataClass = "days"))),format.raw/*339.48*/("""

"""),_display_(Seq[Any](/*341.2*/data(broadcast.startTimeText, dataClass = "time",     searchKeyOption = Some(SearchKey.Time)))),format.raw/*341.95*/("""
"""),_display_(Seq[Any](/*342.2*/data(broadcast.endTimeText,   dataClass = "time end", searchKeyOption = Some(SearchKey.Time)))),format.raw/*342.95*/("""


"""),_display_(Seq[Any](/*345.2*/data(
  broadcast.frequency.trim,
  dataClass = "frequency",
  searchKeyOption = Some(SearchKey.Frequency)))),format.raw/*348.47*/("""


"""),_display_(Seq[Any](/*351.2*/data(broadcast.languages, dataClass = "languages", searchKeyOption = Some(SearchKey.Languages)))),format.raw/*351.97*/("""


"""),_display_(Seq[Any](/*354.2*/data(broadcast.targetZones, dataClass = "target"))),format.raw/*354.51*/("""


"""),_display_(Seq[Any](/*357.2*/data(broadcast.power,      dataClass = "power"))),format.raw/*357.49*/("""
"""),_display_(Seq[Any](/*358.2*/data(broadcast.modulation, dataClass = "modulation"))),format.raw/*358.54*/("""
"""),_display_(Seq[Any](/*359.2*/data(broadcast.azimuth,    dataClass = "azimuth"))),format.raw/*359.51*/("""

"""),_display_(Seq[Any](/*361.2*/data(broadcast.note, dataClass = "note"))),format.raw/*361.42*/("""

"""),_display_(Seq[Any](/*363.2*/data(
  schedule.locationName(broadcast.locationId),
  dataClass = "location-name",
  searchKeyOption = Some(SearchKey.LocationName)))),format.raw/*366.50*/("""
"""),_display_(Seq[Any](/*367.2*/data(
  schedule.locationCountryName(broadcast.locationId),
  dataClass = "location-country",
  searchKeyOption = Some(SearchKey.LocationCountry)))),format.raw/*370.53*/("""
"""),_display_(Seq[Any](/*371.2*/data(schedule.locations(broadcast.locationId).longitude, dataClass = "longitude"))),format.raw/*371.83*/("""
"""),_display_(Seq[Any](/*372.2*/data(schedule.locations(broadcast.locationId).latitude,  dataClass = "latitude"))),format.raw/*372.82*/("""

        <td class="more-info-cell">
            <a class="more-info-link" id=""""),_display_(Seq[Any](/*375.44*/broadcast/*375.53*/.id)),format.raw/*375.56*/("""">Info</a>
        </td>
    </tr>
    """)))})),format.raw/*378.6*/("""

    </tbody>

</table>

""")))})),format.raw/*384.2*/("""
""")))})),format.raw/*385.2*/("""
""")))})),format.raw/*386.2*/("""

<div id="details" style="display:none"></div>
"""))}
    }
    
    def render(schedule:models.radio.Schedule,queryString:Map[String, Seq[String]],form:Form[models.radio.query.Query],sortKeysOption:Option[models.radio.query.SortKeys.Type],pagerOption:Option[Pager[models.radio.Broadcast]]) = apply(schedule,queryString,form,sortKeysOption,pagerOption)
    
    def f:((models.radio.Schedule,Map[String, Seq[String]],Form[models.radio.query.Query],Option[models.radio.query.SortKeys.Type],Option[Pager[models.radio.Broadcast]]) => play.api.templates.Html) = (schedule,queryString,form,sortKeysOption,pagerOption) => apply(schedule,queryString,form,sortKeysOption,pagerOption)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 24 17:25:01 MSK 2012
                    SOURCE: /home/dmitry/Scala/HFCCScheduleViewer/app/views/browse.scala.html
                    HASH: b3627e9e1ae9787a5ac2b76327f01638abf09ef7
                    MATRIX: 656->1|1002->825|1014->829|1123->874|1163->879|1193->900|1233->902|1275->909|1336->948|1372->953|1398->959|1411->964|1517->1006|1555->1008|1580->1024|1590->1032|1621->1054|1661->1056|1699->1058|1741->1078|1761->1086|1782->1098|1807->1106|1832->1111|1847->1118|2029->1236|2073->1245|2122->1272|2160->1274|2209->1301|2252->1309|2281->1329|2291->1339|2326->1365|2366->1367|2413->1378|2445->1401|2456->1415|2494->1444|2534->1446|2607->1483|2653->1507|2692->1510|2725->1521|2780->1540|2834->1585|2874->1587|2967->1644|3029->1684|3085->1704|3119->1729|3158->1730|3186->1739|3199->1743|3238->1744|3279->1753|3344->1786|3376->1811|3397->1823|3437->1825|3475->1827|3508->1838|3543->1851|3570->1867|3591->1879|3631->1881|3669->1883|3702->1894|3736->1902|3771->1917|3784->1922|4003->2077|4047->2086|4096->2113|4139->2121|4202->2175|4257->2192|4315->2214|4346->2223|4403->2243|4422->2252|4454->2261|4513->2283|4532->2292|4564->2301|4604->2304|4644->2321|4709->2349|4742->2372|4791->2374|4817->2386|4831->2390|4880->2392|4919->2404|4979->2427|5013->2438|5073->2461|5121->2499|5161->2500|5200->2506|5240->2514|5275->2528|5288->2532|5446->2625|5499->2641|5531->2650|5576->2659|5607->2680|5618->2690|5655->2717|5696->2719|5767->2753|5823->2786|5863->2789|5896->2799|5927->2819|5949->2831|5990->2833|6029->2835|6067->2853|6100->291|6110->294|6470->643|6485->650|6687->229|6715->289|6743->640|6772->822|6801->956|6830->1108|6859->1914|6889->2525|6919->2864|7059->2968|7103->2989|7407->3257|7422->3263|7473->3304|7514->3306|7604->3359|7651->3383|7758->3454|7871->3544|7909->3546|8025->3639|8064->3642|8115->3670|8153->3672|8218->3714|8256->3716|8307->3744|8337->3852|8375->3854|8488->3944|8527->3947|8640->4037|8679->4040|8738->4076|8777->4079|8882->4161|8920->4163|9040->4260|9078->4262|9192->4353|9231->4356|9334->4436|9373->4439|9428->4471|9467->4474|9518->4502|9592->4540|9681->4606|9719->4608|9806->4672|9845->4675|9934->4741|9972->4743|10059->4807|10098->4810|10192->4881|10230->4883|10327->4957|10365->4959|10426->4997|10464->4999|10525->5037|10600->5076|10662->5115|10700->5117|10765->5159|10804->5162|10895->5230|10933->5232|11024->5300|11063->5303|11220->5437|11259->5440|11320->5478|11359->5481|11423->5522|11461->5524|11528->5568|11794->5798|11821->5815|11832->5820|11865->5843|11906->5845|11948->5851|11963->5856|12052->5922|12075->5929|12097->5941|12138->5943|12173->5947|12411->6149|12463->6191|12504->6193|12637->6290|12673->6316|12714->6318|12806->6378|12847->6383|12883->6409|12924->6411|13011->6466|13053->6472|13094->6503|13135->6505|13237->6575|13279->6581|13315->6607|13356->6609|13448->6664|13539->6732|13601->6762|13642->6767|13678->6793|13719->6795|13846->6885|13939->6955|14001->6985|14047->7013|14060->7018|14099->7019|14130->7058|14169->7061|14212->7094|14253->7096|14383->7208|14396->7213|14435->7214|14474->7217|14495->7228|14528->7251|14582->7266|14642->7290|14794->7419|14832->7421|14997->7563|15037->7567|15155->7662|15193->7664|15311->7759|15350->7762|15419->7808|15458->7811|15574->7904|15612->7906|15728->7999|15768->8003|15898->8110|15938->8114|16056->8209|16096->8213|16168->8262|16208->8266|16278->8313|16316->8315|16391->8367|16429->8369|16501->8418|16540->8421|16603->8461|16642->8464|16798->8597|16836->8599|17005->8745|17043->8747|17147->8828|17185->8830|17288->8910|17406->8991|17425->9000|17451->9003|17523->9043|17582->9070|17616->9072|17650->9074
                    LINES: 19->1|26->30|26->30|28->30|30->32|30->32|30->32|32->34|32->34|34->36|36->40|36->40|38->40|38->40|38->40|38->42|38->42|38->42|38->42|38->42|38->44|38->44|38->46|39->49|39->49|45->53|47->55|47->55|47->55|47->55|49->57|49->57|49->59|49->59|49->59|51->61|51->61|51->63|51->63|51->63|53->65|53->65|53->65|53->65|55->67|55->67|55->67|57->69|57->69|58->70|58->70|58->70|58->70|58->70|58->70|58->70|60->72|62->76|62->76|62->76|62->76|62->76|62->78|64->81|64->81|64->81|64->81|64->81|64->82|68->88|68->88|75->93|77->95|77->95|79->97|79->97|79->97|81->99|81->99|82->100|82->100|82->100|83->101|83->101|83->101|83->101|83->101|84->102|84->102|84->102|84->102|84->102|84->102|84->102|85->103|85->103|86->104|86->104|86->104|86->104|87->105|90->110|90->110|95->113|97->115|97->115|99->117|99->117|99->119|99->119|99->119|100->120|100->120|100->120|100->120|101->123|101->123|101->123|101->123|101->125|104->9|104->9|115->22|115->22|122->5|124->8|125->20|127->28|129->38|131->47|133->86|135->108|137->128|145->136|145->136|155->146|155->146|155->146|155->146|157->148|157->148|164->155|167->158|168->159|171->162|173->164|173->164|174->165|174->165|175->166|175->166|177->171|178->172|181->175|183->177|186->180|188->182|188->182|190->184|193->187|194->188|197->191|198->192|201->195|203->197|206->200|208->202|208->202|210->204|210->204|214->208|214->208|215->209|215->209|217->211|217->211|218->212|218->212|220->214|220->214|221->215|221->215|222->216|222->216|223->217|223->217|229->223|229->223|230->224|230->224|232->226|232->226|233->227|233->227|235->229|239->233|241->235|241->235|243->237|243->237|244->238|244->238|254->248|254->248|254->249|254->249|254->249|255->250|255->250|255->250|256->252|256->252|256->252|256->253|267->264|267->264|267->264|276->273|276->273|276->273|278->275|280->277|280->277|280->277|282->279|285->282|285->282|285->282|287->284|290->287|290->287|290->287|293->290|293->290|297->294|299->296|299->296|299->296|302->299|302->299|306->303|313->310|313->310|313->310|315->312|317->314|317->314|317->314|325->322|325->322|325->322|327->324|327->324|327->324|327->324|329->326|332->329|333->330|336->333|339->336|339->336|340->337|340->337|342->339|342->339|344->341|344->341|345->342|345->342|348->345|351->348|354->351|354->351|357->354|357->354|360->357|360->357|361->358|361->358|362->359|362->359|364->361|364->361|366->363|369->366|370->367|373->370|374->371|374->371|375->372|375->372|378->375|378->375|378->375|381->378|387->384|388->385|389->386
                    -- GENERATED --
                */
            