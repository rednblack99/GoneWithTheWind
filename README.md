# Gone With The Wind

## Description

A Scala application that manages a library of books. It currently supports the following features:

* Stores a list of books
* Allows users to search by complete ISBN, as well as partial author or title
* Allows users to loan a book - with the exception of reference books
* Allows users to check if a book has been loaned

## Installation

* Clone this repo
* Import into IntelliJ IDEA
* Open a terminal in IntelliJ
* Run tests with `$ sbt test`

## Approach

I used Scala Test to test-drive the development of this app, using a red, green, refactor cycle to meet the requirements of each user story in turn. Where possible, I started with the simplest solution and refactored from there (eg. dummy error messages before implementing exceptions).

I attempted the single responsibility principle with regard to classes and methods, but in particular I don't think this was entirely successful regarding the library class. Moving forward I would like to extract 'search' and 'error' into separate classes.

## User Stories

```text
As a visitor,
So that I can find books I am looking for,
I need to be able search books by partial title
```

```text
As a visitor,
So that I can find books I am looking for,
I need to be able search books by partial author
```

```text
As a visitor,
So that I can find books I am looking for,
I need to be able to search by full ISBN
```

```text
As a librarian,
So that I can help my community,
I need to be able to lend books to visitors
```

```text
As a librarian,
So that I can protect my expensive books,
I don't want to lend reference books
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know whether a book is available or on loan
```

---

##### Optional extra stories

```text
As a librarian,
So that I can update my stock levels,
I need to be able update the library when a book is returned 
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know who has a book that is on loan
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know which books are late
```

```text
As a librarian,
So that I can manage my library correctly,
I need to know who has a book that is late
```

```text
As a librarian,
So that I can manage my library correctly,
I want to fine users who are late returning their books

```

## Contributing

If you would like to contribute please feel free to fork this repo, install it using the instructions above and make a pull request with your suggested amends.


