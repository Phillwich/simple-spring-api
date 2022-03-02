package com.Bootcamp.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BooksService booksService;

    @GetMapping("/")
    public List<Object> greeting() {
        Query q = em.createNativeQuery("select * from books");
        return q.getResultList();
    }

    @GetMapping("/get/book/all")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }
    
    
    @GetMapping("/get/book/name/{name}")
    public Books getBookByName(@PathVariable("name") String name) {
        return booksService.getBookByName(name);
    }
    
    
    @GetMapping("/get/book/year/{year}")
    public Books getBookByYear(@PathVariable("year") String year) {
        System.out.println("YEAR" + year);
        return booksService.getBookByYear(Integer.parseInt(year));
    }




    // @PersistenceContext
    // private EntityManager em;


    // @GetMapping("/get/book/all")
    // public List<Object[]> getBooks() {

      
    //     Query q = em.createNativeQuery("select * from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='books'");
    //     List<Object[]> results = q.getResultList();

    //     return results;
    // }
}
