// @SOURCE:/home/dmitry/Scala/HFCCScheduleViewer/conf/routes
// @HASH:6e3c81b597ed63f45a520c66065abc60d63e989d
// @DATE:Tue Dec 25 14:36:37 MSK 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_browse0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_Application_details1 = Route("GET", PathPattern(List(StaticPart("/details"))))
                    

// @LINE:9
val controllers_Application_upload2 = Route("GET", PathPattern(List(StaticPart("/upload"))))
                    

// @LINE:10
val controllers_Application_uploaded3 = Route("POST", PathPattern(List(StaticPart("/uploaded"))))
                    

// @LINE:14
val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.browse"""),("""GET""","""/details""","""controllers.Application.details(broadcast:Int)"""),("""GET""","""/upload""","""controllers.Application.upload"""),("""POST""","""/uploaded""","""controllers.Application.uploaded"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_browse0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.browse, HandlerDef(this, "controllers.Application", "browse", Nil))
   }
}
                    

// @LINE:7
case controllers_Application_details1(params) => {
   call(params.fromQuery[Int]("broadcast", None)) { (broadcast) =>
        invokeHandler(_root_.controllers.Application.details(broadcast), HandlerDef(this, "controllers.Application", "details", Seq(classOf[Int])))
   }
}
                    

// @LINE:9
case controllers_Application_upload2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.upload, HandlerDef(this, "controllers.Application", "upload", Nil))
   }
}
                    

// @LINE:10
case controllers_Application_uploaded3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.uploaded, HandlerDef(this, "controllers.Application", "uploaded", Nil))
   }
}
                    

// @LINE:14
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                