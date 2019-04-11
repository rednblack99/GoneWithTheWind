package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {

  val sampleBooks = List[Book] (
    Book("Da Vinci Code,The", "Brown, Dan", "pidtkl"),
    Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"),
  )

  val library = new Library(sampleBooks)

  test("Library can hold books") {
    assert(library.books === sampleBooks)
  }

  test("error") {
    assert(library.error("isbn") === "Sorry, there is no book with that ISBN number")
    assert(library.error("title") === "Sorry, there are no books containing that title")
    assert(library.error("author") === "Sorry, there are no books written by that author")
  }

  test("searchISBN") {
    assert(library.searchISBN("ipszbehyh") === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
  }

  test("searchTitle") {
    val results = library.searchTitle("Harry Potter")
    assert(results(0) === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
  }

  test("searchAuthor") {
    val results = library.searchAuthor("Rowling")
    assert(results(0) === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
  }

  test("loan") {
    assert(library.onLoan("ipszbehyh") === false)
    library.loan("ipszbehyh")
    assert(library.onLoan("ipszbehyh") === true)
  }

  test("onLoan") {
    assert(library.onLoan("pidtkl") === false)
  }

}
