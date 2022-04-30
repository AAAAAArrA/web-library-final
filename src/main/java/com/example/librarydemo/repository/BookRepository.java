package com.example.librarydemo.repository;

import com.example.librarydemo.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query(value="SELECT * from book where in_library = 1", nativeQuery = true)
    List<Book> getInLibraryBooks();

    @Query(value="SELECT * FROM `book` WHERE `name`= ?;", nativeQuery = true)
    Book getBook(String name);

    @Query(value="SELECT COUNT(id) FROM `book`", nativeQuery = true)
    Integer getBookQuantity();



}
