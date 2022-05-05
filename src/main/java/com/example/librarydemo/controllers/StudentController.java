package com.example.librarydemo.controllers;

import com.example.librarydemo.DTO.*;
import com.example.librarydemo.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;



    @GetMapping("/takenBooks")  //✔
    public ResponseEntity<List<TakenBooks>> getTakenBooks(){

        return ResponseEntity.ok(takenService.getTakenList(userRepository.getUserByUserName(CommonFunc.getCurrentUsersUserName()).getId()));
    }

    @GetMapping("/takenBooksHistory")  //✔
    public ResponseEntity<List<TakenBooksHistory>> getTakenBooksHistory(){

        return ResponseEntity.ok(takenService.getTakenBooksHistory(userRepository.getUserByUserName(CommonFunc.getCurrentUsersUserName()).getId()));
    }

    @GetMapping("/topBooks") //✔
    public ResponseEntity<List<StatisticBookCLassDTO>> getTopBooks(){
        return ResponseEntity.ok(takenService.getBookStatistic());
    }

    @GetMapping("/topEBooks") //
    public ResponseEntity<List<StatisticEBookDTO>> getTopEBooks(){
        return ResponseEntity.ok(takenService.getEBookStatistic());
    }




}
