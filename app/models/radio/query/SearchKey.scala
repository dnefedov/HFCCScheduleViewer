package models.radio.query


final object SearchKey extends Enumeration {

  val StationName     = Value("stationname")
  val StationCountry  = Value("stationcountry")

  val Date            = Value("date")
  val Time            = Value("time")

  val Frequency       = Value("frequency")

  val Languages       = Value("languages")

  val LocationName    = Value("locationname")
  val LocationCountry = Value("locationcountry")

}
