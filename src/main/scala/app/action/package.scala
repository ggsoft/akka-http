package app

import app.model._
import org.json4s.NoTypeHints
import org.json4s.jackson.Serialization
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}

package object action {

  def grp = Group.toHtml.map(_.render).mkString

  def stl(id: Long) = Student.toHtml(id).map(_.render).mkString

  implicit val formats = Serialization.formats(NoTypeHints)

  def toJson(o: AnyRef) = Serialization.write(o)

  def toHtml(s: String) = {
    HttpEntity(ContentTypes.`text/html(UTF-8)`, s)
  }

}