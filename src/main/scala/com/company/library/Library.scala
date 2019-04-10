package com.company.library

class Library(val books: List[Book] = Books.all) {

  def searchISBN(isbn: String): Book = {
    val result = books.find(book => book.ISBN == isbn).head
    if(result == null) println("Sorry, there is no book with that ISBN number")
    result
  }

  def searchTitle(title: String): Book = {
    val result = books.find(book => book.title == title).head
    if(result == null) println("Sorry, there is no book with that title")
    result
  }


}
