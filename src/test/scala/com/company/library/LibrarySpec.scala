package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {

  test("some words to describe my test") {
    "aString" shouldBe "aString"
  }

  test("Library Dummy test returns hello world") {
    val library = new Library()
    assert(library.hello() === "Hello world")
  }

}
