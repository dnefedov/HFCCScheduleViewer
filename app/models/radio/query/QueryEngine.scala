package models.radio.query

import java.text.DecimalFormat
import java.util.Locale

import models.radio.{Broadcast, Schedule}
import models.radio.query.SortKey.Name._


/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 6:50 PM
 */
final object QueryEngine {

  private val toUpperCaseLocale = Locale.US

  def query(schedule: Schedule, query: Query): Seq[Broadcast] = {

    // TODO: Get .view before search and .force after sort.
    val matches = search(schedule, query, schedule.broadcasts)

    sort(schedule, query, matches)

  }

  private def search(
    schedule: Schedule,
    query: Query,
    broadcasts: Seq[Broadcast]): Seq[Broadcast] = {

    val boundFilters: Seq[(Option[String], (Broadcast, String) => Boolean)] =
      Seq(

        query.stationNameOption    -> caseInsensitiveMatch({ b =>
          schedule.stationName(       b.stationId) }),
        query.stationCountryOption -> caseInsensitiveMatch({ b =>
          schedule.stationCountryName(b.countryId) }),


        (query.dateOption flatMap {
          _ => query.dateTextOption
        }) -> inSemiOpenInterval({ _.startDateText }, { _.endDateText }),

        (query.timeOption flatMap {
          _ => query.timeTextOption
        }) -> inSemiOpenInterval({ _.startTimeText }, { _.endTimeText }),


        (query.frequencyOption map {
          frequency => new DecimalFormat("#####").format(frequency)
        }) -> caseInsensitiveMatch({ _.frequency }),

        query.languagesOption -> caseInsensitiveMatch({ _.languages }),


        query.locationNameOption    -> caseInsensitiveMatch({ b =>
          schedule.locationName(       b.locationId) }),
        query.locationCountryOption -> caseInsensitiveMatch({ b =>
          schedule.locationCountryName(b.locationId) })
      )

    boundFilters.foldRight(schedule.broadcasts.view) { (boundFilter, items) =>

      boundFilter._1 match {

        case Some(someSearchValue) => {

          val searchValueUpperCase =
            someSearchValue.toUpperCase(toUpperCaseLocale)

          items filter { broadcast =>

            boundFilter._2(broadcast, searchValueUpperCase)

          }

        }

        case None => items

      }

    }.force

  }

  private def caseInsensitiveMatch(
    accessor: Broadcast => String): (Broadcast, String) => Boolean = {

    (broadcast, searchValueUpperCase) => {

      accessor(broadcast).toUpperCase(toUpperCaseLocale).
        contains(searchValueUpperCase)

    }

  }

  private def inSemiOpenInterval(
    accessor1: Broadcast => String,
    accessor2: Broadcast => String): (Broadcast, String) => Boolean = {

    (broadcast, searchValue) => {

      accessor1(broadcast) <= searchValue && searchValue < accessor2(broadcast)

    }

  }

  private def sort(
    schedule: Schedule,
    query: Query,
    broadcasts: Seq[Broadcast]): Seq[Broadcast] = {

    query.sortOption match {

      case Some(someSortParam) => {

        val sortKeys = SortKeys.parse(someSortParam)

        val comparisons = new Comparisons(schedule)

        sortKeys.foldRight(broadcasts.view) { (sortKey, items) =>

          items sortWith comparisons.functionFor(sortKey)

        }.force

      }

      case None => broadcasts

    }

  }

  private final class Comparisons(private[this] val schedule: Schedule) {

    def functionFor(sortKey: SortKey):
    (Broadcast, Broadcast) => Boolean = { (b1, b2) =>

      val accessor = (accessorForString/* orElse accessors For Other Types */)(sortKey.name)

      ( sortKey.asc && (accessor(b1) < accessor(b2))) ||
        (!sortKey.asc && (accessor(b2) < accessor(b1)))

    }

    private val accessorForString:
    PartialFunction[SortKey.Name.Value, Broadcast => String] = {

      case StationName     => { b => schedule.stationName(b.stationId) }
      case StationCountry  => { b => schedule.stationCountryName(b.countryId) }

      case StartDate       => { b => b.startDateText }
      case EndDate         => { b => b.endDateText }
      case StartTime       => { b => b.startTimeText }
      case EndTime         => { b => b.endTimeText }

      case Frequency       => { b => b.frequency }
      case Languages       => { b => b.languages }

      case Power           => { b => b.power }
      case Modulation      => { b => b.modulation }
      case Azimuth         => { b => b.azimuth }

      case Note            => { b => b.note }

      case LocationName    => { b => schedule.locationName(b.locationId) }
      case LocationCountry => { b =>
        schedule.locationCountryName(b.locationId)
      }

    }

  }

}
