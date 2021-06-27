package com.sky.db

import org.specs2.matcher.MustThrownExpectations
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

class KeyValueStoreTest extends Specification {

  "KeyValueStoreTest" should {
    "set and then get" in new TestCase {
      ???
    }
  }

  trait TestCase extends Scope with MustThrownExpectations {
    val store = new KeyValueStore()(ExecutionContext.global)
    def await[T](f: Future[T]): T = Await.result(f, 2.seconds)
  }
}
