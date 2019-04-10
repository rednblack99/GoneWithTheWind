package com.company.library

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LibrarySpec extends FunSuite {

  val sampleBooks = List[Book] (
    Book("Da Vinci Code,The", "Brown, Dan", "pidtkl"),
    Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"),
    Book("Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", "iamvmb")
  )

  test("Library can hold books") {
    val library = new Library(sampleBooks)
    assert(library.books === sampleBooks)
  }

  test("Visitors can search by complete ISBN") {
    val library = new Library(sampleBooks)
    assert(library.searchISBN("ipszbehyh") === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
  }

  test("Visitors can search by complete title") {
    val library = new Library(sampleBooks)
    val results = library.searchTitle("Harry Potter")
    assert(results(0) === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
    assert(results(1) === Book("Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", "iamvmb"))
    results should not contain Book("Da Vinci Code,The", "Brown, Dan", "pidtkl")
  }


}
