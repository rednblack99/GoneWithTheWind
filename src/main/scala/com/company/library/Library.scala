package com.company.library

class Library(val books: List[Book] = Books.all) {

  def error(searchType: String): String = {
    searchType match {
      case "isbn" => "Sorry, there is no book with that ISBN number"
      case "title" => "Sorry, there are no books containing that title"
      case "author" => "Sorry, there are no books written by that author"
    }
  }

  def searchISBN(isbn: String): Book = {
    val result = books.find(book => book.ISBN == isbn).head
    if(result == null) println(error("isbn"))
    result
  }

  def searchTitle(title: String): List[Book] = {
    val results = books.filter(_.title.contains(title))
    if(results == null) println(error("title"))
    results
  }

  def searchAuthor(name: String): List[Book] = {
    val results = books.filter(_.author.contains(name))
    if(results == null) println(error("author"))
    results
  }


}
