package models.radio

import models.general.{AbstractNamed, Identifiable}


/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 4:13 PM
 */
final class Station private[radio] (id: Identifiable#Id, name: String)
  extends AbstractNamed(id, name) {

}
