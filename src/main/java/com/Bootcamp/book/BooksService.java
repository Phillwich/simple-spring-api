package com.Bootcamp.book;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getBooks() {
        List<Books> allBooks = booksRepository.findAll();
        allBooks = allBooks.stream().map(books -> this.parseYearOfBook(books)).toList();
        return allBooks;
    }

    public Books getBookByName(String name) {
        return booksRepository.findBookByTitle(name);
    }

    public List<Books> getBookByYear(String year) {
        return booksRepository.findAllByYearWritten(year);
    }

    public Books parseYearOfBook(Books books) {
        books.yearWritten = "Jahr " + books.yearWritten;
        return books;
    }
}
