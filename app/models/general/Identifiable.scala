package models.general

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/6/12
 * Time: 7:28 PM
 */
trait Identifiable {

  type Id = String

  def id: Id

}
