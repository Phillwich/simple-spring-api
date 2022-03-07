package com.Bootcamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Bootcamp.book.Books;
import com.Bootcamp.book.BooksService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationTests.class)
class ApplicationTests {

    @Test
    void trueTest() {
        assertEquals(true, true);
    }
    

    @Test
    void parseBookDate() {
        Books books = new Books();
        books.id = 100L;
        books.author = "Philipp Hellwich";
        books.title = "The yourney of a consultant";
        books.yearWritten = "1996";
        BooksService booksService = new BooksService();

        Books parsedBook = booksService.parseYearOfBook(books);

        assertEquals(parsedBook.yearWritten, "Jahr 1996");
    }

}