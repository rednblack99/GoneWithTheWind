package com.company.library

import org.scalatest.FunSuite
import org.scalatest._
import org.scalatest.Matchers._

class FeatureSpec extends FunSuite {

  val sampleBooks = List[Book] (
    Book("Da Vinci Code,The", "Brown, Dan", "pidtkl"),
    Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"),
    Book("Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", "iamvmb"),
    Book("God Delusion,The", "Dawkins, Richard", "giuivxo", true)
  )

  val library = new Library(sampleBooks)

  test("Users can search by complete ISBN") {
    assert(library.searchISBN("ipszbehyh") === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
  }

  test("Users can search by partial title") {
    val results = library.searchTitle("Harry Potter")
    assert(results(0) === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
    assert(results(1) === Book("Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", "iamvmb"))
    results should not contain Book("Da Vinci Code,The", "Brown, Dan", "pidtkl")
  }

  test("Users can search by partial author") {
    val results = library.searchAuthor("Rowling")
    assert(results(0) === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
    assert(results(1) === Book("Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", "iamvmb"))
    results should not contain Book("Da Vinci Code,The", "Brown, Dan", "pidtkl")
  }

  test("Users can loan books") {
    library.loan("ipszbehyh")
    assert(library.onLoan("ipszbehyh") === true)
  }

  test("Users can return books to the library") {
    library.loan("iamvmb")
    assert(library.onLoan("iamvmb") === true)
    library.returnBook("iamvmb")
    assert(library.onLoan("iamvmb") === false)
  }

  test("User can check if a book is on loan") {
    assert(library.onLoan("iamvmb") === false)
  }

  test("Reference books cannot be loaned out") {
    library.loan("giuivxo")
    assert(library.onLoan("giuivxo") === false)
  }

  test("User can see name of person who loaned book") {
    library.loan("iamvmb", "Jasper Fforde")
    assert(library.whoLoaned("iamvmb") === "Jasper Fforde")
  }

}
