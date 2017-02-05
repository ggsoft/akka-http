package app.model

import scala.collection.mutable.ListBuffer
import scalatags.Text.all._

case class Group(id: Long, name: String)

object Group {

  val list = ListBuffer(Group(1,"Group 1"), Group(2,"Group 2"), Group(3,"Group 3"))
  val notFound = Group(0l,"")

  def find(id: Long) = list.find(_.id==id).getOrElse(notFound)

  def add(g: Group) = {
    list += g.copy(id=list.map(_.id).max+1)
  }

  def upd(g: Group) = {
    val i = list.map(_.id).indexOf(g.id)
    if (i > -1) list.update(i,g)
  }

  def del(id: Long) = {
    list.find(_.id==id).map(g => list-=g)
  }

  def toHtml = list.map(g => li(a(href:="/list/"+g.id,g.name)))

}




