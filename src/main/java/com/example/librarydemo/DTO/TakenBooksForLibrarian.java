package com.example.librarydemo.DTO;

import java.sql.Date;


public interface TakenBooksForLibrarian {
    int getId();
    int getBookId();
    String getBookName();
    String getBookAuthor();
    Date getStartDate();
    int getStudentId();
    String getStudentName();
    String getLibrarianName();

}
