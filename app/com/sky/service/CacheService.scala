package com.sky.service

import com.sky.db.KeyValueStore

import javax.inject.{Inject, Singleton}
import scala.concurrent.Future

@Singleton
class CacheService @Inject()(store: KeyValueStore) {

  def get(key: String): Future[Option[String]] = ???
}
