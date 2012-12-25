package models.radio

import models.general.{AbstractNamed, Identifiable}

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/25/12
 * Time: 17:00 PM
 */
final class Organization private[radio] (
    id: Identifiable#Id,
    name: String,
    val unions: String)
  extends AbstractNamed(id, name) {

}
