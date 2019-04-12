package com.company.library

import java.time._
import codes.reactive.scalatime._


case class Loan(book: Book, name: String, loanLength: Int, loanStart: LocalDate, lateFee: Int) {

  val LoanEnd: LocalDate = loanStart plusDays loanLength

  def late: Boolean = {
    LocalDate.now isAfter LoanEnd
  }

  def calculateFine(currentDate: LocalDate = LocalDate.now): Int = {
    println(LoanEnd)
    println(LocalDate.now)
    Period.between(LoanEnd, currentDate).getDays()
  }

}
