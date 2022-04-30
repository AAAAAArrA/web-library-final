package com.example.librarydemo.repository;

import com.example.librarydemo.models.EBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EBookRepository extends CrudRepository<EBook, Integer> {
    @Query(value="SELECT COUNT(id) FROM `e_book`", nativeQuery = true)
    Integer getEBookQuantity();
}
