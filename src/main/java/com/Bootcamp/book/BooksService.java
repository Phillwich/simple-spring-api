package com.Bootcamp.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    
    @Autowired
    private BooksRepository booksRepository;

    // public BooksService(BooksRepository booksRepository) {
    //     this.booksRepository = booksRepository;
    // }

    public List<Books> getBooks() {
        List<Books> allBooks = booksRepository.findAll();
        allBooks = allBooks.stream().map(books -> this.parseYearOfBook(books)).toList();

        return allBooks;
    }

    public Books getBookByName(String name) {
        Books books = booksRepository.findBookByTitle(name);
        books = this.parseYearOfBook(books);

        return books;
    }

    public List<Books> getBookByYear(String year) {
        List<Books> matchedBooks = booksRepository.findAllByYearWritten(year);
        matchedBooks = matchedBooks.stream().map(books -> this.parseYearOfBook(books)).toList();

        return matchedBooks;
    }

    public Books parseYearOfBook(Books books) {
        books.yearWritten = "Jahr " + books.yearWritten;
        return books;
    }
}
