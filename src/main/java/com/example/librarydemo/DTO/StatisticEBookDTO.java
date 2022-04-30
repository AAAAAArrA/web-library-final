package com.example.librarydemo.DTO;

public interface StatisticEBookDTO {
    int getId();
    int getBookId();
    String getName();
    String getAuthor();
    int getReleaseYear();
    String getPhoto();
    int getDownloadedQuantity();
    int getViewedQuantity();
}
