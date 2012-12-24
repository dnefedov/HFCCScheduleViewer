package models.radio

import models.general.{AbstractNamed, Identifiable}

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 5:20 PM
 */
final class Country private[radio] (id: Identifiable#Id, name: String)
  extends AbstractNamed(id, name) {

}
