package com.sky.db

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

/**
 * Dummy stub for a key/value store such as redis
 */
@Singleton
class KeyValueStore @Inject()(implicit ec: ExecutionContext) {

  /**
   * Get the value for the given key
   * @return the value for the given key or None if the key does not exist in the key-value store
   */
  def get(key: String): Future[Option[String]] = Future {
   ???
  }

  /**
   * Set the given key to the given value
   * @return the previous value for the given key or None if the key didn't previously exist in the key-value store
   */
  def set(key: String, value: String): Future[Option[String]] = Future {
    ???
  }
}
