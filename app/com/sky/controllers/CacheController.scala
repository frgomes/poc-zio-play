package com.sky.controllers

import com.sky.service.CacheService
import play.api.libs.json._
import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CacheController @Inject()(cacheService: CacheService, cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def get(key: String) = Action.async { implicit request: Request[AnyContent] =>
    cacheService.get(key)
      .map {
        case Some(value) => Ok(Json.toJson(value))
        case None        => NotFound(Json.toJson("key not found: ${key}"))
      }
  }

  def set(key: String, value: String) = Action.async { implicit request: Request[AnyContent] =>
    cacheService.set(key, value)
      .map {
        case Some(value) => Ok(Json.toJson(value))
        case None        => NotFound(Json.toJson("key not found: ${key}"))
      }
  }

}

object models {
  case class GetResponse(value: String)

  object GetResponse {
    implicit val fmt: Format[GetResponse] = Json.format[GetResponse]
  }
}

