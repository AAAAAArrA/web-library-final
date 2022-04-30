package com.example.librarydemo.controllers;

import com.example.librarydemo.DTO.StatisticBookDTO;
import com.example.librarydemo.DTO.StatisticEBookDTO;
import com.example.librarydemo.DTO.TakenBooks;
import com.example.librarydemo.DTO.TakenBooksHistory;
import com.example.librarydemo.services.TakenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private TakenService takenService;

    @GetMapping("/takenBooks")  //ok
    public ResponseEntity<List<TakenBooks>> getTakenBooks(){
        return ResponseEntity.ok(takenService.getTakenList(1));
    }

    @GetMapping("/takenBooksHistory")  //ok
    public ResponseEntity<List<TakenBooksHistory>> getTakenBooksHistory(){

        return ResponseEntity.ok(takenService.getTakenBooksHistory(1));
    }

    @GetMapping("/topBooks")
    public ResponseEntity<List<StatisticBookDTO>> getTopBooks(){
        return ResponseEntity.ok(takenService.getBookStatistic());
    }

    @GetMapping("/topEBooks")
    public ResponseEntity<List<StatisticEBookDTO>> getTopEBooks(){
        return ResponseEntity.ok(takenService.getEBookStatistic());
    }




}
