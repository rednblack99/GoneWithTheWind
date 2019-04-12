package com.company.library

import java.time._
import codes.reactive.scalatime._


case class Loan(book: Book, name: String, loanLength: Int, loanStart: LocalDate, lateFee: Int) {

  val loanEnd: LocalDate = loanStart plusDays loanLength

  def late: Boolean = {
    LocalDate.now isAfter loanEnd
  }

}
