package models.radio

import models.general.{AbstractIdentifiable, Identifiable}


/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 11:14 AM
 */
final class Broadcast private[radio] (
    id: Identifiable#Id,
    val stationId: String,
    val countryId: String,
    val startDateText: String,
    val endDateText: String,
    val daysOfWeek: String,
    val startTimeText: String,
    val endTimeText: String,
    val frequency: String,
    val languages: String,
    val targetZones: String,
    val locationId: String,
    val power: String,
    val modulation: String,
    val azimuth: String,
    val note: String)
  extends AbstractIdentifiable(id) {

}
