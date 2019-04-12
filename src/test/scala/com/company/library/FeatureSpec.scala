package com.company.library

import java.time.LocalDate

import org.scalatest.FunSuite
import org.scalatest._
import org.scalatest.Matchers._

class FeatureSpec extends FunSuite {

  val sampleBooks = List[Book] (
    Book("Da Vinci Code,The", "Brown, Dan", "pidtkl"),
    Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"),
    Book("Harry Potter and the Prisoner of Azkaban", "Rowling, J.K.", "iamvmb"),
    Book("God Delusion,The", "Dawkins, Richard", "giuivxo", true),
    Book("Eats, Shoots and Leaves:The Zero Tolerance Approach to Punctuation", "Truss, Lynne", "tfmsxhk"),
    Book("Northern Lights:His Dark Materials S.", "Pullman, Philip", "lgzf")

  )

  val library = new Library(sampleBooks)
  val library2 = new Library(sampleBooks)

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
    library.loan("ipszbehyh", "N/A", 14, LocalDate.now)
    assert(library.onLoan("ipszbehyh") === true)
  }

  test("Users can return books to the library") {
    library.loan("iamvmb", "N/A", 14, LocalDate.now)
    assert(library.onLoan("iamvmb") === true)
    library.returnBook("iamvmb")
    assert(library.onLoan("iamvmb") === false)
  }

  test("User can check if a book is on loan") {
    assert(library.onLoan("iamvmb") === false)
  }

  test("Reference books cannot be loaned out") {
    library.loan("giuivxo", "N/A", 14, LocalDate.now)
    assert(library.onLoan("giuivxo") === false)
  }

  test("Librarian can see name of person who loaned book") {
    library.loan("tfmsxhk", "Jasper Fforde", 14, LocalDate.now)
    assert(library.whoLoaned("tfmsxhk") === "Jasper Fforde")
    library.loan("lgzf", "Everybody sensible", 14, LocalDate.now)
    assert(library.whoLoaned("lgzf") === "Everybody sensible")
  }

  test("Librarian can see which loans are late") {
    library2.loan("tfmsxhk", "Jasper Fforde", 1, LocalDate.of(2014, 6, 7))
    library2.loan("lgzf", "Everybody sensible", 14, LocalDate.now)
    val result = library2.lateLoans
    assert(result(0) === Loan(Book("Eats, Shoots and Leaves:The Zero Tolerance Approach to Punctuation", "Truss, Lynne", "tfmsxhk", false, true), "Jasper Fforde", 1, LocalDate.of(2014, 6, 7)))
    result should not contain Loan(Book("Northern Lights:His Dark Materials S.", "Pullman, Philip", "lgzf", false, true), "Everybody sensible", 14, LocalDate.now)
  }

  test("Librarian can see names and associated fines of those with late loans") {
    val result = library2.usersWithLateLoan
    assert(result(0) === "Jasper Fforde: £5")
    result should not contain("Everybody sensible")
  }

}