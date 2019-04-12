package com.company.library

import java.time._
import codes.reactive.scalatime._


case class Loan(book: Book, name: String, loanLength: Int, loanStart: LocalDate) {

  def late: Boolean = {
    if (loanStart plusDays loanLength isBefore LocalDate.now) true else false
  }

}
