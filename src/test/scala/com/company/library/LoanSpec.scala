package com.company.library

import java.time.LocalDate

import org.scalatest.FunSuite
import org.scalatest._
import org.scalatest.Matchers._

class LoanSpec extends FunSuite {

  val loan = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "John Doe")

  test("Holds relevant info") {
    assert(loan.book === Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"))
    assert(loan.name === "John Doe")
    assert(loan.loanLength === 14)
    assert(loan.loanStart === LocalDate.now)
  }

  test("late - returns Boolean for whether loan is late") {
    val loan1 = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "Jasper Fforde", 1, LocalDate.of(2014, 6, 7))
    val loan2 = new Loan(Book("Harry Potter and the Deathly Hallows", "Rowling, J.K.", "ipszbehyh"), "Everybody sensible")
    assert(loan1.late === true)
    assert(loan2.late === false)
  }

}
