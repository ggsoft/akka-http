package app.action

import akka.http.scaladsl.server.Directives._
import app.model._
import app.view.Index

object Site {

  val route =
    pathSingleSlash {
      get {
        complete(toHtml(Index.page("main",0l)))
      }
    } ~ path("about") {
      get {
        complete(toHtml(Index.page("about",0l)))
      }
    } ~ path("list") {
      get {
        complete(toHtml(Index.page("list",0l)))
      }
    } ~ pathPrefix("list" / IntNumber) { id =>
      get {
        complete(toHtml(Index.page("list", id.toLong)))
      }
    } ~ path("addgrp") {
         get {
           parameters('name.as[String]) { name =>
             if (name != "") Group.add(Group(0l, name))
             complete {
               grp
             }
           }
         }
    } ~ path("updstd") {
      get {
        parameters('id.as[Long]) { id =>
          complete {
            toJson(Student.find(id))
          }
        }
      }
    } ~ path("editgrp") {
          get {
            parameters('id.as[Long], 'name.as[String]) { (id, name) =>
              if (name != "") Group.upd(Group(id, name))
              complete {
                grp
              }
            }
          }
    } ~ path("delgrp") {
      get {
        parameters('id.as[Long]) { id =>
          Group.del(id)
          complete {
            grp
          }
        }
      }
    }  ~ path("addstd") {
      get {
        parameters('id.as[Long], 'name.as[String], 'ball.as[Int]) { (id, name, ball) =>
          if (name != "") Student.add(Student(0l, id, name, ball))
          complete {
            stl(id)
          }
        }
      }
    }  ~ path("editstd") {
      get {
        parameters('id.as[Long], 'idGrp.as[Long], 'name.as[String], 'ball.as[Int]) { (id, idGrp, name, ball) =>
          if (name != "") Student.upd(Student(id,idGrp,name,ball))
          complete {
            stl(idGrp)
          }
        }
      }
    }  ~ path("delstd") {
      get {
        parameters('id.as[Long], 'idGrp.as[Long]) { (id, idGrp) =>
          Student.del(id)
          complete {
            stl(idGrp)
          }
        }
      }
    } ~ pathPrefix("css") {
        getFromDirectory("public/css")
      } ~ pathPrefix("js") {
        getFromDirectory("public/js")
      } ~ pathPrefix("fonts") {
        getFromDirectory("public/fonts")
      }

}

