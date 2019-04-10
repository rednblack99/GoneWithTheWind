package com.company.library

class Library(val books: List[Book] = Books.all) {

  def searchISBN(isbn: String): Book = {
    val result = books.find(book => book.ISBN == isbn).head
    if(result == null) println("Sorry, there is no book with that ISBN number")
    result
  }

  def searchTitle(title: String): List[Book] = {
    val results = books.filter(_.title.contains(title))
    if(results == null) println("Sorry, there are no books containing that title")
    results
  }

  def searchAuthor(name: String): List[Book] = {
    val results = books.filter(_.author.contains(name))
    if(results == null) println("Sorry, there are no books written by that author")
    results
  }


}
