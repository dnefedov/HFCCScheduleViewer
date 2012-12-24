package models.radio.query

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/10/12
 * Time: 11:48 PM
 */
final case class SortKey(val name: SortKey.Name.Value, val asc: Boolean) {

}

final object SortKey {

  final object Name extends Enumeration {

    val StationName    = Value("stationname")
    val StationCountry = Value("stationcountry")

    val StartDate      = Value("startdate")
    val EndDate        = Value("enddate")
    val StartTime      = Value("starttime")
    val EndTime        = Value("endtime")

    val Frequency      = Value("frequency")

    val Languages      = Value("languages")

    val Power          = Value("power")
    val Modulation     = Value("modulation")
    val Azimuth        = Value("azimuth")

    val Note           = Value("note")

    val LocationName    = Value("locationname")
    val LocationCountry = Value("locationcountry")

  }

  final object Order extends Enumeration {

    val Asc = Value("asc")
    val Dsc = Value("dsc")

  }

}
