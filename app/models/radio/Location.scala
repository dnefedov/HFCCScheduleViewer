package models.radio

import models.general.{AbstractNamed, Identifiable}

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 4:20 PM
 */
final class Location private[radio] (
    id: Identifiable#Id,
    name: String,
    val countryId: String,
    val longitude: String,
    val latitude: String)
  extends AbstractNamed(id, name) {

}
