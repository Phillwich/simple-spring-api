package com.Bootcamp.book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Books, Long> {
    Books findBookByTitle(String title);
    Books findBookByYear(Integer year_written);
}
