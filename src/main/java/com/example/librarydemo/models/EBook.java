package com.example.librarydemo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="e_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String description;
    private String photo;
    private int releaseYear;
    private String link;


    @ManyToOne
    @JoinColumn
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "eBookId")
    private List<StatisticEBook> statisticEBooks;
}
