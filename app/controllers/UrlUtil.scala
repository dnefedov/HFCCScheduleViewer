package controllers

import java.net.URLEncoder

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/16/12
 * Time: 10:12 PM
 */
final object UrlUtil {

  def fullUrl(url: String, queryString: Map[String, Seq[String]]): String = {

    /* Copied from file play.api.mvc.Results.scala */
    url + Option(queryString).filterNot(_.isEmpty).map { params =>
      (if (url.contains("?")) "&" else "?") + params.toSeq.flatMap { pair =>
        pair._2.map(value => (pair._1 + "=" + URLEncoder.encode(value, "utf-8")))
      }.mkString("&")
    }.getOrElse("")

  }

}
