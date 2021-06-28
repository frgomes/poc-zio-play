package com.sky.service

import com.sky.db.KeyValueStore

import javax.inject.{Inject, Singleton}
import scala.concurrent.Future

import zio._
import java.io.IOException

import io.mathminds.zio.cache.LRUCacheLike
import io.mathminds.zio.cache.ConcurrentLRUCache


@Singleton
class CacheService @Inject()(store: KeyValueStore) {
  def get(key: String): Future[Option[String]] = store.get(key)
  def set(key: String, value: String): Future[Option[String]] = store.set(key, value)
}
