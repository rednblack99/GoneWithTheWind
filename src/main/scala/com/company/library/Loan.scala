package com.company.library

import java.time._


case class Loan(book: Book, name: String, loanLength: Int, loanStart: LocalDate, lateFee: Int) {

  val LoanEnd: LocalDate = loanStart plusDays loanLength

  def late: Boolean = {
    LocalDate.now isAfter LoanEnd
  }

  def calculateFine(currentDate: LocalDate = LocalDate.now): Int = {
    if(currentDate isBefore LoanEnd) throw new Exception("This book loan isn't late")
    if(currentDate.getMonth != LoanEnd.getMonth) throw new Exception("Unfortunately this method can't handle month overdue books yet!")
    Period.between(LoanEnd, currentDate).getDays
  }

}
