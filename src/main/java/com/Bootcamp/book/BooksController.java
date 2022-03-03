package com.Bootcamp.book;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/get/book/all")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }
    
    
    @GetMapping("/get/book/{name}")
    public Books getBookByName(@PathVariable String name) {
        return booksService.getBookByName(name);
    }
    
    
    @GetMapping("/get/book/year/{year}")
    public List<Books> getBookByYear(@PathVariable String year) {       
        return booksService.getBookByYear(year);
    }
}
