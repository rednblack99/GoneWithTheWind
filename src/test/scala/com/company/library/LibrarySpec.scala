package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._
import java.time._
import codes.reactive.scalatime._

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
    assertThrows[Exception] { library.throwError("isbn")}
    assertThrows[Exception] { library.throwError("title")}
    assertThrows[Exception] { library.throwError("author")}
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
    library.loan("ipszbehyh", "N/A", 14, LocalDate.now)
    assert(library.onLoan("ipszbehyh") === true)
  }

  test("onLoan") {
    assert(library.onLoan("pidtkl") === false)
  }

  test("returnBook") {
    library.loan("pidtkl", "N/A", 14, LocalDate.now)
    library.returnBook("pidtkl")
    assert(library.onLoan("pidtkl") === false)
  }


}
