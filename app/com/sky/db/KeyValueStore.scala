package com.sky.db

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext}
import play.api.Configuration

/**
  * A multithreaded, lock-free, efficient, in-memory LRU cache with optional support for secondary storage.
  * 
  * NOTE: support for a secondary storage, such as Redis, is not supported at this time.
  * For more information, please see: http://github.com/frgomes/lru-cache
  */
@Singleton
class KeyValueStore @Inject()(runtime: zio.Runtime[zio.ZEnv], config: Configuration)(implicit ec: ExecutionContext) {
  import zio._
  import io.mathminds.zio.cache.ConcurrentLRUCache
  import scala.concurrent.Future
  import java.io.IOException

  val capacity = config.get[Int]("cache.capacity")
  val effect = ConcurrentLRUCache.make[String, String](capacity)

  /**
   * Get the value for the given key
   * @return the value for the given key or None if the key does not exist in the key-value store
   */
  def get(key: String): Future[Option[String]] =
    runtime.unsafeRunToFuture {
      for {
        lruCache <- effect
        value <- lruCache.get(key)
      } yield Some(value)
    }

  /**
   * Set the given key to the given value
   * @return the previous value for the given key or None if the key didn't previously exist in the key-value store
   */
  def set(key: String, value: String): Future[Option[String]] =
    runtime.unsafeRunToFuture {
      for {
        lruCache <- effect
        _ <- lruCache.put(key, value)
      } yield Some(value)
    }

}
