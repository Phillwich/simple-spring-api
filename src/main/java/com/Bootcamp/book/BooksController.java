package com.Bootcamp.book;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class BooksController {

    private final BooksService booksService;
    private final Counter bookByYearCounter;
    private final Counter allBooksCounter;
    private final Counter bookByNameCounter;

    public BooksController(BooksService booksService, MeterRegistry meterRegistry) {
        this.booksService = booksService;
        bookByYearCounter = meterRegistry.counter("booksByYearCounter");
        bookByNameCounter = meterRegistry.counter("bookByNameCounter");
        allBooksCounter = meterRegistry.counter("allBooksCounter");
    }

    @GetMapping("/")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/get/book/all")
    public List<Books> getBooks() {
        allBooksCounter.increment();
        return booksService.getBooks();
    }
    
    @GetMapping("/get/book/{name}")
    public Books getBookByName(@PathVariable String name) {
        bookByNameCounter.increment();
        return booksService.getBookByName(name);
    }
    
    @GetMapping("/get/book/year/{year}")
    public List<Books> getBookByYear(@PathVariable String year) {       
        bookByYearCounter.increment();
        return booksService.getBookByYear(year);
    }
}
