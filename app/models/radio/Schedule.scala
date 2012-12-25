package models.radio

import java.io.{File, IOException}
import java.util.zip.{ZipEntry, ZipFile}

import collection.JavaConverters._
import collection.immutable.HashMap
import io.Source

import play.api.Logger

import scalaz._
import Scalaz._

import org.joda.time.{LocalDate, LocalTime}

import models.general.Identifiable
import types.Union._

/**
 * Created with IntelliJ IDEA.
 * User: dmitry
 * Date: 12/1/12
 * Time: 4:09 PM
 */
final class Schedule private (
    val countries: Schedule#MapIdTo[Country],
    val stations:  Schedule#MapIdTo[Station],
    val locations: Schedule#MapIdTo[Location],
    val broadcasts: Schedule#SeqOf[Broadcast]) {

  type Element <: Identifiable

  type MapIdTo[Element] = Map[Identifiable#Id, Element]

  type SeqOf[Element] = Seq[Element]


  def stationName(stationId: Identifiable#Id): String =
    if (stations.contains(stationId)) stations(stationId).name else stationId

  def stationCountryName(countryId: Identifiable#Id): String =
    if (countries.contains(countryId)) countries(countryId).name else countryId


  def locationName(locationId: Identifiable#Id): String =
    if (locations.contains(locationId))
      locations(locationId).name
    else
      locationId

  def locationCountryName(locationId: Identifiable#Id): String = {

    if (locations.contains(locationId)) {

      val countryId = locations(locationId).countryId

      if (countries.contains(countryId))
        countries(countryId).name
      else
        countryId

    } else locationId

  }

}

final object Schedule {

  private[Schedule] object builders {

    abstract sealed class Builder
    [Element <: Identifiable,
    CollectionType : (Schedule#MapIdTo[Element] Or Schedule#SeqOf[Element])#Type] {

      def createEmptyCollection: CollectionType

      def createElement(line: String): Element

      def addElement(collection: CollectionType, element: Element):
      CollectionType

    }

    abstract sealed class AbstractMapBuilder[Element <: Identifiable]
      extends Builder[Element, Schedule#MapIdTo[Element]] {

      def createEmptyCollection: Schedule#MapIdTo[Element] =
        Map[String, Element]()

      def addElement(collection: Schedule#MapIdTo[Element], element: Element):
      Schedule#MapIdTo[Element] = {

        collection + (element.id -> element)

      }
    }

    abstract sealed class AbstractVectorBuilder[Element <: Identifiable]
      extends Builder[Element, Schedule#SeqOf[Element]] {

      def createEmptyCollection: Schedule#SeqOf[Element] = Vector[Element]()

      def addElement(
        collection: Schedule#SeqOf[Element],
        element: Element): Schedule#SeqOf[Element] = {

        collection :+ element

      }
    }

    final object CountryMapBuilder extends AbstractMapBuilder[Country] {

      def createElement(line: String): Country = {

        // TODO: Handle error lengths
        val id   = line.substring(0, 3)
        val name = line.substring(4, 54).trim

        new Country(id, name)
      }

    }

    final object StationMapBuilder extends AbstractMapBuilder[Station] {

      def createElement(line: String): Station = {

        // TODO: Handle error lengths
        val id   = line.substring(0, 3)
        val name = line.substring(4).trim

        new Station(id, name)
      }

    }

    final object LocationMapBuilder extends AbstractMapBuilder[Location] {

      def createElement(line: String): Location = {

        // TODO: Handle error lengths
        val id        = line.substring(0, 3)
        val name      = line.substring(4, 34).trim
        val countryId = line.substring(35, 38)
        val longitude = line.substring(45)
        val latitude  = line.substring(39, 44)

        new Location(id, name, countryId, longitude, latitude)
      }

    }

    final class BroadcastMapBuilder extends AbstractVectorBuilder[Broadcast] {

      private[this] var counter = 0

      def createElement(line: String): Broadcast = {

        val id = {
          counter += 1
          counter }.toString

        // TODO: Handle error lengths
        val frequency     = line.substring(0, 5) //.trim
        val startTimeText = line.substring(6, 8)   + ":" + line.substring(8, 10)

        val endTimeText = line.substring(11, 13) + ":" + line.substring(13, 15)
        val endTimeTextCorrected =
          /* if (endTimeText == "24:00") "23:59" else */ endTimeText


        val targetZones = line.substring(16, 46).trim.
          replace(",", ", ").replace("-", "\u2013")

        val locationId    = line.substring(47, 50)
        val power         = line.substring(51, 55)//.trim
        val azimuth       = line.substring(56, 63)//.trim

        val daysOfWeek = line.substring(72, 79)
        val daysOfWeekBuilder = new StringBuilder()
        for (i <- 1 to 7) {
          val dayChar =
            if (daysOfWeek.contains(i.toString))
              BroadcastMapBuilder.daysOfWeekFirsLetters(i)
            else
              '.'
          daysOfWeekBuilder.append(dayChar)
        }
        val daysOfWeekCorrected = daysOfWeekBuilder.toString

        val startDateText = BroadcastMapBuilder.correctDayText(
                              line.substring(80, 86).trim)
        val endDateText   = BroadcastMapBuilder.correctDayText(
                              line.substring(87, 93).trim)
        val modulation    = line.substring(94, 95)
        val languages     = line.substring(102, 112).trim
        val countryId     = line.substring(113, 116).trim
        val stationId     = line.substring(117, 120)
        val note = if (line.length > 151) line.substring(151).trim else ""


        new Broadcast(
          id,
          stationId,
          countryId,
          startDateText,
          endDateText,
          daysOfWeekCorrected,
          startTimeText,
          endTimeTextCorrected,
          frequency,
          languages,
          targetZones,
          locationId,
          power,
          modulation,
          azimuth,
          note)
      }

    }

    final object BroadcastMapBuilder {

      private val daysOfWeekFirsLetters =
        Map(1 -> 'S', 2 -> 'M', 3-> 'T', 4 -> 'W', 5-> 'T', 6 -> 'F', 7 -> 'S')

      private def correctDayText(dayText: String): String = {
        "20" + dayText.substring(4) +
          "-" + dayText.substring(2, 4) + "-" + dayText.substring(0, 2)
      }

    }

  }

  def createFromFile(file: File): Option[Schedule] = {

    Logger.info(
      "Creating schedule from file [" + file.getAbsolutePath + "]...")

    val zipFile = new ZipFile(file)

    val countriesValidation = parseZipEntry(
      zipFile,
      "admin.txt",
      builders.CountryMapBuilder)

    val stationsValidation = parseZipEntry(
      zipFile,
      "broadcas.txt",
      builders.StationMapBuilder)

    val locationsValidation = parseZipEntry(
      zipFile,
      "site.txt",
      builders.LocationMapBuilder)

    val broadcastsValidation = parseZipEntry(
      zipFile,
      "B12all00.TXT", // TODO: Use regexp
      new builders.BroadcastMapBuilder)

    val scheduleValidation = (countriesValidation  |@|
                               stationsValidation  |@|
                               locationsValidation |@|
                               broadcastsValidation) {

      new Schedule(_, _, _, _)

    }

    // TODO: Proper placement.
    Logger.info(
      "Finished creating schedule from file [" + file.getAbsolutePath + "].")

    scheduleValidation match {
      case Success(schedule) => {
        Logger.info("Succesfully parsed schedule.")

        Some(schedule)
      }
      case Failure(f) => {
        // TODO: Proper error message.
        Logger.error("Parsing failed, with the following errors:")

        // f.foreach { Logger.error(_) }

        None
      }
    }
  }

  private def parseZipEntry
  [Element <: Identifiable,
  CollectionType : (Schedule#MapIdTo[Element] Or Schedule#SeqOf[Element])#Type] (
    zipFile: ZipFile,
    entryName: String,
    builder: builders.Builder[Element, CollectionType]):
      ValidationNEL[String, CollectionType] = {

    Logger.info("Parsing zip entry [" + entryName + "]...")

    val zipEntryIterator = zipFile.entries.asScala
    val zipEntryOption = zipEntryIterator find { _.getName == entryName }

    zipEntryOption match {

      case Some(zipEntry) => {

        var sourceOption: Option[Source] = None
        try {
          val source = Source.fromInputStream(
            zipFile.getInputStream(zipEntry), "ISO-8859-1")
          sourceOption = Some(source)

          val lineIterator = source.getLines

          // Skip header
          val dataLineIterator = lineIterator dropWhile { _.startsWith(";") }

          // Check whether there exists some data about countries
          if (!dataLineIterator.hasNext)
            "No valid country lines".failNel[CollectionType]
          else {
            var collection = builder.createEmptyCollection

            dataLineIterator foreach { line =>

              val element = builder.createElement(line)

              collection = builder.addElement(collection, element)
            }

            // TODO: Proper placement.
            Logger.info("Finished parsing zip entry [" + entryName + "].")

            collection.successNel[String]
          }

        } finally {

          sourceOption match {

            case Some(someSource) => {
              try {
                someSource.close()
              } catch {
                case ex: IOException => {
                  // TODO: Log error.
                }
              }
            }
            case None => { }

          }

        }

      }

      case None => {
        ("Zip entry " + entryName + "is not found in schedule file").
          failNel[CollectionType]
      }
    }
  }
}