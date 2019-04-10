package com.company.library

class Library(val books: List[Book] = Books.all) {

  def searchISBN(isbn: String): Book = {
    books.find(book => book.ISBN == isbn).head
  }
}
