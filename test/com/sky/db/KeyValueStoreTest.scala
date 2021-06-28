package com.sky.db

import org.specs2.matcher.MustThrownExpectations
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

class KeyValueStoreTest extends Specification {

  "KeyValueStoreTest" should {
    "set and then get" in new TestCase {
      case class Results(a: String, b: String, c: String, d: String, e: String, f: String, g: String, h: String, i: String)
      val expected = Results("1", "2", "1", "3", "*", "4", "*", "3", "4")
      implicit val context = ec
      for {
        a <- store.set("1", "1")
        b <- store.set("2", "2")
        c <- store.get("1")
        d <- store.set("3", "3")
        e <- store.get("2")
        f <- store.set("4", "4")
        g <- store.get("1")
        h <- store.get("3")
        i <- store.get("4")
      } yield {
        val actual =
          Results(a.getOrElse("*"),
            b.getOrElse("*"),
            c.getOrElse("*"),
            d.getOrElse("*"),
            e.getOrElse("*"),
            f.getOrElse("*"),
            g.getOrElse("*"),
            h.getOrElse("*"),
            i.getOrElse("*"))
        assert(expected == actual)
      }

    }
  }

  trait TestCase extends Scope with MustThrownExpectations {
    val runtime = zio.Runtime.default
    val config = play.api.Configuration.from(Map("cache.capacity" -> "10"))
    val ec = ExecutionContext.global
    val store = new KeyValueStore(runtime, config)(ec)
    def await[T](f: Future[T]): T = Await.result(f, 2.seconds)
  }
}
