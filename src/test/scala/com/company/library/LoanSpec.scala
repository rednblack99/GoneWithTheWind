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

}
