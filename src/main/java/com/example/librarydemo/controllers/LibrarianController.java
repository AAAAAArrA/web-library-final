package com.example.librarydemo.controllers;


import com.example.librarydemo.DTO.*;
import com.example.librarydemo.enums.Role;
import com.example.librarydemo.exceptions.CustomException;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.models.Category;
import com.example.librarydemo.models.Photo;
import com.example.librarydemo.models.User;
import com.example.librarydemo.repository.CategoryRepository;
import com.example.librarydemo.services.BookService;
import com.example.librarydemo.services.TakenService;
import com.example.librarydemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private TakenService takenService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/addBook")  //✔
    public ResponseEntity addBook(@ModelAttribute BookDTO bookDTO) throws IOException {
        bookService.creatBook(bookDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/inLibraryBooks") //✔
    public ResponseEntity<List<Book>> getInLibraryBooks(){
        return ResponseEntity.ok(bookService.InLibraryBookList());
    }

    @PostMapping("/editBook") //✔
    public ResponseEntity editBook(@ModelAttribute BookDTO bookDTO) throws IOException{
        bookService.editBook(bookDTO);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/deletedBooks") //✔
    public ResponseEntity getDeletedBooks(){
        return ResponseEntity.ok(bookService.getDeletedBooks());
    }

    @PostMapping("/editStudent") //✔
    public ResponseEntity editStudent(@RequestBody User student){
        userService.editStudent(student);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/student/{student_id}") //✔
    public ResponseEntity<User> getBStudent(@PathVariable("student_id") long id){

        User student = userService.getStudent(id);

        return ResponseEntity.ok(student);
    }


    @GetMapping("/book/{book_id}")    //✔
    public ResponseEntity<Book> getBook(@PathVariable("book_id") long id){

        Book book = bookService.findBookById(id);

        return ResponseEntity.ok(book);
    }

    @PostMapping("/addStudent")   //✔
    public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO){

        boolean success = userService.createStudent(studentDTO);

        if(success){
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }    }

    @GetMapping("/books")  //✔
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.BookList());
    }

    @GetMapping("/taken")   //✔
    public ResponseEntity<List<TakenBooksForLibrarian>> getTakenBooks(){
        return ResponseEntity.ok(takenService.getTakenBooksForLibrarian());
    }

    @PostMapping("/giveBook")  //✔
    public ResponseEntity giveBook(@RequestBody TakenDTO book) throws CustomException, ParseException {
        int code = takenService.giveBook(book);

        if(code == 404){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/topBooks") //✔
    public ResponseEntity<List<StatisticBookCLassDTO>> getTopBooks(){
        return ResponseEntity.ok(takenService.getBookStatistic());
    }

    @GetMapping("/topEBooks") //
    public ResponseEntity<List<StatisticEBookDTO>> getTopEBooks(){
        return ResponseEntity.ok(takenService.getEBookStatistic());
    }

    @GetMapping("/topViewedEBooks") //
    public ResponseEntity<List<StatisticEBookDTO>> getTopViewedEBooks(){
        return ResponseEntity.ok(takenService.getViewedEBookStatistic());
    }

    @GetMapping("/deleteBook/{book_id}") //✔
    public ResponseEntity deleteBook(@PathVariable long book_id){
        bookService.deleteBook(book_id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/students") //✔
    public ResponseEntity<List<User>> getStudents(){
        return ResponseEntity.ok(userService.getStudents());
    }


    @PostMapping("/takeBook") //✔
    public ResponseEntity takeBook(@RequestBody TakenDTO book) throws ParseException, CustomException {
        int code = takenService.takeBook(book);

        if(code == 404){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/bookQuantity")//✔
    public ResponseEntity getBookQuantity(){
        return ResponseEntity.ok(bookService.getBookQuantity());
    }

    @GetMapping("/eBookQuantity")//✔
    public ResponseEntity getEBookQuantity(){
        return ResponseEntity.ok(bookService.getEBookRepository());
    }

    @GetMapping("/takenHistory")//✔
    public ResponseEntity getTakenHistory(){
        return ResponseEntity.ok(takenService.getTakenHistory());
    }











}
