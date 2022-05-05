package com.example.librarydemo.repository;

import com.example.librarydemo.DTO.StatisticEBookDTO;
import com.example.librarydemo.models.StatisticEBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticEBookRepository extends CrudRepository<StatisticEBook, Long> {
    @Query(value="SELECT s.id as id, s.e_book_id as bookId, b.name as name, b.author as author, b.release_year as releaseYear, b.photo as photo, s.downloaded_quantity as downloadedQuantity, s.viewed_quantity as viewedQuantity FROM `statistic_e_book` as s JOIN `book` as b on s.e_book_id = b.id order by `downloaded_quantity` desc limit 20 ", nativeQuery = true)
    List<StatisticEBookDTO> getTopBooks();

    @Query(value="SELECT s.id as id, s.e_book_id as bookId, b.name as name, b.author as author, b.release_year as releaseYear, b.photo as photo, s.downloaded_quantity as downloadedQuantity, s.viewed_quantity as viewedQuantity FROM `statistic_e_book` as s JOIN `book` as b on s.e_book_id = b.id order by `viewed_quantity` desc limit 20 ", nativeQuery = true)
    List<StatisticEBookDTO> getTopViewedBooks();


}
