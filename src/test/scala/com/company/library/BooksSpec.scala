package com.company.library

import org.scalatest.FunSuite
import org.scalatest._
import org.scalatest.Matchers._

class BooksSpec extends FunSuite {

  test("Book object holds correct info") {
    val book = Book("Da Vinci Code,The", "Brown, Dan", "pidtkl", false)
    assert(book.title === "Da Vinci Code,The")
    assert(book.author === "Brown, Dan")
    assert(book.ISBN === "pidtkl")
    assert(book.onLoan === false)
  }


}
