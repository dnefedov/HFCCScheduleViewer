package models.radio.query

import java.util.Date


/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 6:49 PM
 */
final case class Query (
  val stationNameOption:     Option[String] = None,
  val stationCountryOption:  Option[String] = None,

  val dateTextOption:        Option[String] = None,
  val dateOption:            Option[Date]   = None,
  val timeTextOption:        Option[String] = None,
  val timeOption:            Option[Date]   = None,

  val frequencyOption:       Option[Int]    = None,
  val languagesOption:       Option[String] = None,

  val locationNameOption:    Option[String] = None,
  val locationCountryOption: Option[String] = None,

  val sortOption:            Option[String] = None,

  val pageOption:            Option[Int]    = None) {

}
