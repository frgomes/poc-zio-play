package com.sky.controllers

import com.sky.service.CacheService
import play.api.libs.json._
import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CacheController @Inject()(cacheService: CacheService, cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def get(key: String) = Action.async { implicit request: Request[AnyContent] =>
    Future.successful(NotFound(s"$key Not Found - to be implemented"))
  }

  def findKeys(searchTerm: String) = Action.async { implicit request: Request[AnyContent] =>
    Future.successful(NotFound(s"$searchTerm Not Found - to be implemented"))
  }

}

object models {
  case class GetResponse(value: String)

  object GetResponse {
    implicit val fmt: Format[GetResponse] = Json.format[GetResponse]
  }
}

