package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {

  val sampleBooks = List[Book] (
    Book("Da Vinci Code,The", "Brown, Dan", "pidtkl"),
    Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh")
  )

  test("Library can hold books") {
    val library = new Library(sampleBooks)
    assert(library.books === sampleBooks)
  }

}
