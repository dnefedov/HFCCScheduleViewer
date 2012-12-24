package models.general

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 4:29 PM
 */
abstract class AbstractNamed protected (id: String, val name: String)
  extends AbstractIdentifiable(id) with Named {

}
