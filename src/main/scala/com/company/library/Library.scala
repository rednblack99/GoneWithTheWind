package com.company.library

class Library(val books: List[Book] = Books.all) {

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

  def loan(isbn: String): Unit = {
    val result = books.find(book => book.ISBN == isbn).head
    if (result.onLoan) throwError("onLoan")
    if (!result.reference) result.onLoan = true
  }

  def onLoan(isbn: String): Boolean = {
    val result = books.find(book => book.ISBN == isbn).head
    if (result.onLoan) true else false
  }

  def returnBook(isbn: String): Unit = {
    val result = books.find(book => book.ISBN == isbn).head
    if(!result.onLoan) throwError("alreadyReturned")
    result.onLoan = false
  }


}
