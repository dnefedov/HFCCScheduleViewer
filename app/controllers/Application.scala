package controllers

import java.io.File

import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller, SimpleResult}
import play.api.templates.Html

import scalaz._
import Scalaz._

import global.Global
import models.radio.Broadcast
import models.radio.query.{Query, QueryEngine, SearchKey, SortKeys}


object Application extends Controller {

  private[this] val queryForm = Form[Query](

    mapping(

      SearchKey.StationName.toString     -> optional(text),
      SearchKey.StationCountry.toString  -> optional(text),

      SearchKey.Date.toString            -> optional(text),
      SearchKey.Date.toString            -> optional(date("yyyy-MM-dd")),
      SearchKey.Time.toString            -> optional(text),
      SearchKey.Time.toString            -> optional(date("HH:mm")),

      SearchKey.Frequency.toString       -> optional(number(min = 2300, max = 26100)),

      SearchKey.Languages.toString       -> optional(text),

      SearchKey.LocationName.toString    -> optional(text),
      SearchKey.LocationCountry.toString -> optional(text),


      SortKeys.paramName -> optional(
          text.verifying("sort.error", { param => SortKeys.areValid(param) } )
      ),


      Pager.paramName -> optional(number(min = 1))

    )(Query.apply)(Query.unapply)
  )

  def browse = Action { implicit request =>

    Global.scheduleOption match {

      case None => {

        // Redirect(routes.Application.upload)

        addCacheHeaders(
          Ok(views.html.main("Browse")(views.html.browsenoschedule())))

      }

      case Some(someSchedule) => {

        val boundQueryForm = queryForm.bindFromRequest

        Logger.debug("Bound form has errors = [" + boundQueryForm.hasErrors
          + "], global errors = [" + boundQueryForm.hasGlobalErrors + "].")

        boundQueryForm.fold(

          formWithErrors => {

            val content = views.html.browse(
              someSchedule,
              request.queryString,
              boundQueryForm,
              sortKeysOption = None,
              pagerOption = None)

            addCacheHeaders(Ok(views.html.main("Browse")(content)))

          },

          query => {

            assert(query == boundQueryForm.get)

            Logger.debug("Station          = [" + query.stationNameOption
              + "].")
            Logger.debug("Station country  = [" + query.stationCountryOption
              + "].")
            Logger.debug("Date             = [" + query.dateOption
              + "].")
            Logger.debug("Time             = [" + query.timeOption
              + "].")
            Logger.debug("Frequency        = [" + query.frequencyOption
              + "].")
            Logger.debug("Language         = [" + query.languagesOption
              + "].")
            Logger.debug("Location         = [" + query.locationNameOption
              + "].")
            Logger.debug("Location country = [" + query.locationCountryOption
              + "].")
            Logger.debug("Sort             = [" + query.sortOption
              + "].")

            query.sortOption match {

              case None => {

                Redirect("/",
                  request.queryString +
                    (SortKeys.paramName -> Seq(SortKeys.defaultParamValue)),
                  SEE_OTHER)

              }

              case Some(someSortParam) => {

                val someSortKeys = Some(SortKeys.parse(someSortParam))

                val broadcasts = QueryEngine.query(someSchedule, query)

                val page = query.pageOption match {
                  case Some(somePageIndex) => somePageIndex
                  case None => Pager.defaultPageIndex
                }
                val somePager = Some(new Pager[Broadcast](broadcasts, page))


                boundQueryForm("Abc").hasErrors

                val content = views.html.browse(
                  someSchedule,
                  request.queryString,
                  boundQueryForm,
                  someSortKeys,
                  somePager)

                addCacheHeaders(Ok(views.html.main("Browse")(content)))

              }

            }

          }

        )

      }

    }

  }

  def details(broadcastId: Int) = Action {

    Global.scheduleOption match {

      case Some(someSchedule) => {

        // TODO: Check for existence.
        val broadcast = someSchedule.broadcasts(broadcastId - 1)
        val organization = someSchedule.organizations(broadcast.organizationId)
        val content = views.html.details(someSchedule, organization)

        Ok(content)
      }

      case None => Ok(views.html.detailsnoschedule())
    }

  }

  def upload = Action {

    val content = views.html.upload()
    Ok(views.html.main("Upload new data")(content))

  }

  def uploaded = Action(parse.multipartFormData) { request =>

    request.body.file("schedule") map { uploadedFile =>

      val contentType = uploadedFile.contentType

      val storedFile = File.createTempFile(uploadedFile.filename, ".tmp")
      storedFile.deleteOnExit()

      uploadedFile.ref.moveTo(storedFile, replace = true)


      val content = if (Global.handleScheduleFile(storedFile))
        views.html.uploadedsuccess()
      else
        views.html.uploadedfail()

      addCacheHeaders(
        Ok(views.html.main("Upload new data")(content)))

    } getOrElse {

      addCacheHeaders(
        Ok(views.html.main("Upload new data")(views.html.uploadedfail())))

    }

  }

  private def addCacheHeaders(
    simpleResult: SimpleResult[Html]): SimpleResult[Html] =
      simpleResult.withHeaders(CACHE_CONTROL -> "max-age=0")

}
