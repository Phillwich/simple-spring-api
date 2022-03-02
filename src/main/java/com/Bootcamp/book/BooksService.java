package com.Bootcamp.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    
    @Autowired
    private BooksRepository booksRepository;

    public List<Books> getBooks() {
        List<Books> allBooks = new ArrayList<Books>();
        Iterable<Books> data = booksRepository.findAll();
        data.forEach(result -> allBooks.add(result));

        return allBooks;
    }

    public Books getBookByName(String name) {
        return booksRepository.findBookByTitle(name);
    }

    public Books getBookByYear(Integer year) {
        return booksRepository.findBookByYear(year);
    }
}
