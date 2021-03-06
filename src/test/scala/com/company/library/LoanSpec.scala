package com.company.library

import java.time.LocalDate

import org.scalatest.FunSuite
import org.scalatest._
import org.scalatest.Matchers._

class LoanSpec extends FunSuite {

  val Loan = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "John Doe", 14, LocalDate.now, 1)

  test("Holds relevant info") {
    assert(Loan.book === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
    assert(Loan.name === "John Doe")
    assert(Loan.loanLength === 14)
    assert(Loan.loanStart === LocalDate.now)
    assert(Loan.lateFee === 1)
  }

  test("late - returns Boolean for whether loan is late") {
    val loan1 = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "Jasper Fforde", 1, LocalDate.of(2014, 6, 7), 1)
    val loan2 = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "Everybody sensible", 14, LocalDate.now, 1)
    assert(loan1.late === true)
    assert(loan2.late === false)
  }

  test("calculate fine") {
    val loan = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "Jasper Fforde", 1, LocalDate.of(2014, 6, 7), 1)
    assert(loan.calculateFine(LocalDate.of(2014, 6, 13)) === 5)
  }

}
