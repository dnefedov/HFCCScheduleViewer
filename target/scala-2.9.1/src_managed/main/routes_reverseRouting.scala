// @SOURCE:/home/dmitry/Scala/HFCCScheduleViewer/conf/routes
// @HASH:6e3c81b597ed63f45a520c66065abc60d63e989d
// @DATE:Tue Dec 25 14:36:37 MSK 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:14
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers {

// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def browse() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:9
def upload() = {
   Call("GET", "/upload")
}
                                                        
 
// @LINE:7
def details(broadcast:Int) = {
   Call("GET", "/details" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("broadcast", broadcast)))))
}
                                                        
 
// @LINE:10
def uploaded() = {
   Call("POST", "/uploaded")
}
                                                        

                      
    
}
                            

// @LINE:14
class ReverseAssets {
    


 
// @LINE:14
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:14
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def browse = JavascriptReverseRoute(
   "controllers.Application.browse",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:9
def upload = JavascriptReverseRoute(
   "controllers.Application.upload",
   """
      function() {
      return _wA({method:"GET", url:"/upload"})
      }
   """
)
                                                        
 
// @LINE:7
def details = JavascriptReverseRoute(
   "controllers.Application.details",
   """
      function(broadcast) {
      return _wA({method:"GET", url:"/details" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("broadcast", broadcast)])})
      }
   """
)
                                                        
 
// @LINE:10
def uploaded = JavascriptReverseRoute(
   "controllers.Application.uploaded",
   """
      function() {
      return _wA({method:"POST", url:"/uploaded"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:14
class ReverseAssets {
    


 
// @LINE:14
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:14
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def browse() = new play.api.mvc.HandlerRef(
   controllers.Application.browse(), HandlerDef(this, "controllers.Application", "browse", Seq())
)
                              
 
// @LINE:9
def upload() = new play.api.mvc.HandlerRef(
   controllers.Application.upload(), HandlerDef(this, "controllers.Application", "upload", Seq())
)
                              
 
// @LINE:7
def details(broadcast:Int) = new play.api.mvc.HandlerRef(
   controllers.Application.details(broadcast), HandlerDef(this, "controllers.Application", "details", Seq(classOf[Int]))
)
                              
 
// @LINE:10
def uploaded() = new play.api.mvc.HandlerRef(
   controllers.Application.uploaded(), HandlerDef(this, "controllers.Application", "uploaded", Seq())
)
                              

                      
    
}
                            

// @LINE:14
class ReverseAssets {
    


 
// @LINE:14
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                