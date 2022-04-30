package com.example.librarydemo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
     int id;
     String name;
     String author;
     String description;
     String photo;
     int releaseYear;
     String category;


}
