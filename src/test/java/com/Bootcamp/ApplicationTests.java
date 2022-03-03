package com.Bootcamp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Bootcamp.book.Books;
import com.Bootcamp.book.BooksService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    BooksService booksService;

	@Test
	void contextLoads() {
	}

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
        
        Books parsedBook = this.booksService.parseYearOfBook(books);

        assertEquals(parsedBook.yearWritten, "Jahr 1996");
    }

}