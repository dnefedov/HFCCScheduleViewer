package global

import java.io.File

import play.api.{Application, GlobalSettings, Logger, Play}

import models.radio.Schedule

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/1/12
 * Time: 10:27 AM
 */
final object Global extends GlobalSettings {

  @volatile
  private var _scheduleOption: Option[Schedule] = None

  def scheduleOption: Option[Schedule] = _scheduleOption;


  override def onStart(app: Application) {

    Logger.info("Starting application...")


    Play.current.configuration.getString("schedule.file.pathname") match {

      case Some(someScheduleFilePathname) => {

        handleScheduleFile(new File(someScheduleFilePathname))

      }

      case None => {}

    }

    Logger.info("Application has started.")

  }

  override def onStop(app: Application) {

    Logger.info("Application shutdown...")

  }

  def handleScheduleFile(file: File): Boolean = {

    Logger.info("Handling schedule file [" + file.getAbsolutePath + "]...")

    _scheduleOption = Schedule.createFromFile(file)

    Logger.info(
      "Finished handling schedule file [" + file.getAbsolutePath + "].")

    _scheduleOption != None

  }

}
