package com.Bootcamp.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query(
    value = "SELECT * FROM books WHERE year_written = :year_written", 
    nativeQuery = true)
    List<Books> findAllByYearWritten(String year_written);


    @Query(
    value = "SELECT * FROM books WHERE title = :name", 
    nativeQuery = true)
    Books findBookByTitle(String name);
}
