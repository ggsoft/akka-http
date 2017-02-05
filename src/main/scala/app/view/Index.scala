package app.view

import app.model._

import scalatags.Text.all._

object Index {

  def page(pg: String, groupId: Long) =
  "<!DOCTYPE html>"+
    html(lang:="en",
      head(
        meta(name:="viewport", content:="width=device-width, initial-scale=1.0"),
        meta(httpEquiv:="Content-Type", content:="text/html; charset=UTF-8"),
        scalatags.Text.tags2.title("Students and groups"),
        meta(name:="decription", content:="Test project for Spray"),
        link(rel:="stylesheet", href:="/css/bootstrap.min.css"),
        link(rel:="stylesheet", href:="/css/style.css"),
        script(src:="/js/jquery-2.1.4.min.js"),
        script(src:="/js/bootstrap.min.js"),
        script(src:="/js/script.js")
      ),
      body(
        div(`class`:="navbar navbar-default navbar-fixed-top",
          div(`class`:="container",
            div(`class`:="navbar-header",
              button(`type`:="button",`class`:="navbar-toggle")
            ),
            ul(`class`:="nav navbar-nav",
              li(a(href:="/","Main")),
              li(a(href:="/list","List")),
              li(a(href:="/about","About"))
            )
          )
        ),
        div(`class`:="container",
          getCnt(pg,groupId)
        )
      )
    )

  def getCnt(pg: String, groupId: Long) =
    pg match {
      case "main" => mainPage
      case "list" => listPage(groupId)
      case "about" => aboutPage
      case _  =>  p("")
    }

  def mainPage = p("Main page of project will be here")

  def listPage(groupId: Long) = {
    val group = Group.find(groupId)
    div(`class`:="row",
      div(`class`:="col-lg-3",
        ul(id:="listgrp", `class`:="alt", Group.toHtml),
        label(`for`:="grp", "id:"),
        label(`id`:="idgrp", group.id),
        input(id:="grp",`type`:="text",size:="10",value:=group.name),
        div(`class`:="btn-group buttons",
          a(id:="addgrp", title:="Add", href:="#", span(`class`:="glyphicon glyphicon-plus")),
          a(id:="editgrp", title:="Change", href:="#", span(`class`:="glyphicon glyphicon-ok")),
          a(id:="delgrp", title:="Delete", href:="#", span(`class`:="glyphicon glyphicon-remove"))
        )
      ),
      div(`class`:="col-lg-9",
        table(`class`:="table table-bordered",
          thead(tr(th("Id"), th("Name"), th("Score"))),
          tbody(id:="list", Student.toHtml(groupId))
        ),
        label("id:"), label(id:="idstd"),
        label(`for`:="name", "name"),
        input(id:="name", `type`:="text", size:="40"),
        label(`for`:="score", "score"),
        input(id:="score", `type`:="text", size:="10"),
        div(`class`:="btn-group buttons",
          a(id:="addstd", title:="Add", href:="#", span(`class`:="glyphicon glyphicon-plus")),
          a(id:="editstd", title:="Change", href:="#", span(`class`:="glyphicon glyphicon-ok")),
          a(id:="delstd", title:="Delete", href:="#", span(`class`:="glyphicon glyphicon-remove"))
        )
       )
    )
  }

  def aboutPage = p("About page of project will be here")

}


