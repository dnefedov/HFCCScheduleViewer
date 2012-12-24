package controllers

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/12/12
 * Time: 3:18 PM
 */
final class Pager[Item](
    val items: Seq[Item],
    val pageIndex: Int,
    val pageSize: Int = Pager.defaultPageSize) {

  val pageCount: Int = (items.size.toDouble / pageSize.toDouble).ceil.toInt

  val validPageIndex: Int =
    scala.math.max(0, scala.math.min(pageIndex, pageCount))


  def pageItems:      Seq[Item] = { itemsForIndex(pageIndex) }

  def validPageItems: Seq[Item] = { itemsForIndex(validPageIndex) }

  private def itemsForIndex(index: Int): Seq[Item] =
    items.slice((index - 1) * pageSize, index * pageSize)

}

final object Pager {

  val paramName = "page"

  val defaultPageIndex = 1

  val defaultPageSize = 15

}
