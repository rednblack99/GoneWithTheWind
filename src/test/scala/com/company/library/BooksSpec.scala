package com.company.library

import org.scalatest.FunSuite
import org.scalatest._
import org.scalatest.Matchers._

class BooksSpec extends FunSuite {

  test("different words to describe my test") {
    "aString" shouldBe "aString"
  }

  test("Book object can be made") {
    val book = Book("Da Vinci Code,The", "Brown, Dan", "pidtkl")
    assert(book.title === "Da Vinci Code,The")
    assert(book.author === "Brown, Dan")
    assert(book.ISBN === "pidtkl")
  }


}
