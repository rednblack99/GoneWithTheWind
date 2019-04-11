package com.company.library

import scala.collection.mutable.ListBuffer

class Library(val books: List[Book] = Books.all) {

  var loanedBooks = new ListBuffer[Loan]

  def throwError(searchType: String): String = {
    searchType match {
      case "isbn" => throw new Exception("Sorry, there is no book with that ISBN number")
      case "title" => throw new Exception("Sorry, there are no books containing that title")
      case "author" => throw new Exception("Sorry, there are no books written by that author")
      case "onLoan" => throw new Exception("Sorry, that book is already on loan")
      case "alreadyReturned" => throw new Exception("Sorry, that book has already been returned")
    }
  }

  def searchISBN(isbn: String): Book = {
    val result = books.find(book => book.ISBN == isbn).head
    if(result == null) throwError("ISBN")
    result
  }

  def searchTitle(title: String): List[Book] = {
    val results = books.filter(_.title.contains(title))
    if(results == null) throwError("title")
    results
  }

  def searchAuthor(name: String): List[Book] = {
    val results = books.filter(_.author.contains(name))
    if(results == null) throwError("author")
    results
  }

  def loan(isbn: String, name: String = "N/A"): Unit = {
    val result = searchISBN(isbn)
    loanedBooks += Loan(result, name)
    if (result.onLoan) throwError("onLoan")
    if (!result.reference) result.onLoan = true
  }

  def onLoan(isbn: String): Boolean = {
    val result = searchISBN(isbn)
    if (result.onLoan) true else false
  }

  def returnBook(isbn: String): Unit = {
    val result = searchISBN(isbn)
    if(!result.onLoan) throwError("alreadyReturned")
    result.onLoan = false
  }

  def whoLoaned(isbn: String): String = {
    val result = loanedBooks.find(Loan => Loan.book.ISBN == isbn).head
    if(result == null) throwError("ISBN")
    result.name
  }

  def lateLoans: ListBuffer[Loan] = {
    loanedBooks.filter(_.late)
  }

  def usersWithLateLoan: ListBuffer[String] = {
    var lateUsers = new ListBuffer[String]
    val late = lateLoans
    late.foreach {lateUsers += _.name}
    lateUsers
  }

}
