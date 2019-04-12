package com.company.library

import java.time._
import codes.reactive.scalatime._


case class Loan(book: Book, name: String, loanLength: Int, loanStart: LocalDate) {

  def late: Boolean = {
    LocalDate.now isAfter (loanStart plusDays loanLength)
  }

}
