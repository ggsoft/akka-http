package app.model

import scala.collection.mutable.ListBuffer
import scalatags.Text.all._

case class Student(id: Long, grpId: Long, name: String, score: Int)

object Student {

  val l = ListBuffer(Student(1,1,"John Q Smith",25),
    Student(2,1,"Kevin J Allen",51),
    Student(3,1,"Jean K Doyle",75),
    Student(4,1,"Lynn S Dennis",32),
    Student(5,1,"Leslie D Baker",48),
    Student(6,2,"Cynthia D Ward",83),
    Student(7,2,"Daniel T Peters",18),
    Student(8,2,"Karen P Shaw",67),
    Student(9,2,"Sarah S Duncan",21),
    Student(10,3,"Gregory J Lance",95),
    Student(11,3,"Terry M Jones",15),
    Student(12,3,"Chris L Alberts",77)
  )
  val notFound = Student(0l,0l,"",0)

  def find(id: Long) = l.find(_.id==id).getOrElse(notFound)

  def list(grpId: Long) = l.filter(_.grpId==grpId)

  def add(s: Student) = {
    l += s.copy(id=l.map(_.id).max+1)
  }

  def upd(s: Student) = {
    val i = l.map(_.id).indexOf(s.id)
    if (i > -1) l.update(i,s)
  }

  def del(id: Long) = {
    l.find(_.id==id).map(s => l-=s)
  }

  def toHtml(grpId: Long) = list(grpId).map(s => tr(td(s.id),td(a(href:="#",s.name)),td(s.score)))

}
