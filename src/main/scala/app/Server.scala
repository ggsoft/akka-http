package app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import app.action.Site._

object Server {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("system")
    implicit val actorMaterializer = ActorMaterializer()

    Http().bindAndHandle(route,"localhost",8000)
    println("server started at 8000")
  }
}
