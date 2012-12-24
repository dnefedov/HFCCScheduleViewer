package models.radio.query


/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/10/12
 * Time: 4:13 PM
 */
final object SortKeys {

  type Type = Seq[SortKey]

  private val keySeparator  = ","
  private val partSeparator = ":"

  val paramName = "sort"

  val defaultParamValue = format(Seq[SortKey](
      SortKey(SortKey.Name.StationName, true),
      SortKey(SortKey.Name.Languages,   true),
      SortKey(SortKey.Name.StartTime,   true),
      SortKey(SortKey.Name.Frequency,   true)
    )
  )

  def areValid(param: String): Boolean = {

    val singleKeys =
      param.split(keySeparator) map { _.split(partSeparator) }


    val areAllSingleKeysValid = singleKeys forall {
      singleKey => isValid(singleKey)
    }

    val areKeyNamesDistinct =
      singleKeys.size == singleKeys.map({ _(0) }).distinct.size


    areAllSingleKeysValid && areKeyNamesDistinct

  }

  private def isValid(singleKey: Array[String]): Boolean = {

    if (singleKey.length == 2) {

      try {

        SortKey.Name.withName(singleKey(0))
        SortKey.Order.withName(singleKey(1))

        true

      } catch {

        case ex: NoSuchElementException => false

      }

    } else false

  }

  def parse(param: String): SortKeys.Type = {

    param.split(keySeparator) map { _.split(partSeparator) } map { singleKey =>

      SortKey(
        SortKey.Name.withName(singleKey(0)),
        singleKey(1) == SortKey.Order.Asc.toString)

    }

  }

  def format(sortKeys: SortKeys.Type) = {

    sortKeys map { sortKey =>

      sortKey.name + partSeparator +
      (if (sortKey.asc) SortKey.Order.Asc else SortKey.Order.Dsc)

    } mkString(keySeparator)

  }

  def prependAndFormat(
    sortKeys: SortKeys.Type,
    sortKeyName: SortKey.Name.Value,
    reverse: Boolean): String = {

    assert(
      !reverse || (sortKeys.head.name == sortKeyName),
      "Only the primary sort key may be reversed.")


    val (seqOfSameNameKey, otherKeys) = sortKeys partition { _.name == sortKeyName }

    val newPrimaryKey: SortKey =

      if (seqOfSameNameKey.isEmpty)

        SortKey(sortKeyName, true)

      else {

        val sameNameKey = seqOfSameNameKey.head

        if (reverse)
          SortKey(sameNameKey.name, !sameNameKey.asc)
        else
          sameNameKey

      }

    format(Seq(newPrimaryKey) ++ otherKeys)

  }

}
