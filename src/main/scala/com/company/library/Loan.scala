package com.company.library

import java.time._
import codes.reactive.scalatime._


case class Loan(book: Book, name: String, loanLength: Int = 14, loanStart: LocalDate = LocalDate.now) {

  def late: Boolean = {
    if (loanStart plusDays loanLength isBefore LocalDate.now) true else false
  }

}
