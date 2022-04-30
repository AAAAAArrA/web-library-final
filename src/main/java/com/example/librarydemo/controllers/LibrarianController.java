package com.example.librarydemo.controllers;


import com.example.librarydemo.DTO.*;
import com.example.librarydemo.exceptions.CustomException;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.models.Category;
import com.example.librarydemo.repository.CategoryRepository;
import com.example.librarydemo.services.BookService;
import com.example.librarydemo.services.TakenService;
import com.example.librarydemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addBook")  //ok
    public ResponseEntity addBook(@RequestBody BookDTO bookDTO){
        Category category = categoryRepository.getCategoryByName(bookDTO.getCategory());

        Book book = new Book();

        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(category);
        book.setDescription(bookDTO.getDescription());
//        book.setPhoto(bookDTO.getPhoto());
        book.setReleaseYear(bookDTO.getReleaseYear());

        bookService.creatBook(book);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/inLibraryBooks")
    public ResponseEntity<List<Book>> getInLibraryBooks(){
        return ResponseEntity.ok(bookService.InLibraryBookList());
    }

    @PostMapping("/editBook")
    public ResponseEntity editBook(@RequestBody BookDTO bookDTO){
        bookService.editBook(bookDTO);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PostMapping("/editStudent")
    public ResponseEntity editStudent(@RequestBody StudentDTO studentDTO){
        userService.editStudent(studentDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/student/{student_id}")    //ok
    public ResponseEntity<StudentDTO> getBStudent(@PathVariable("student_id") int id){

        StudentDTO studentDTO = userService.getStudent(id);

        return ResponseEntity.ok(studentDTO);
    }


    @GetMapping("/book/{book_id}")    //ok
    public ResponseEntity<Book> getBook(@PathVariable("book_id") int id){

        Book book = bookService.findBookById(id);

        return ResponseEntity.ok(book);
    }

    @PostMapping("/addStudent")   //ok
    public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO){

        Role role = roleRepository.getRoleByName(studentDTO.getRole());


        User user = new User();

        user.setEmail(studentDTO.getEmail());
        user.setFullName(studentDTO.getFullName());
        user.setLogin(studentDTO.getLogin());
        user.setPassword(studentDTO.getPassword());
        user.setPhoneNumber(studentDTO.getPhone());
        user.setRoleId(role);

        userService.creatStudent(user);

        Student student = new Student();

        student.setStudentId(user);
        student.setAddress(studentDTO.getAddress());
        student.setGrop(studentDTO.getGroup());

        userService.addStudent(student);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/books")  //ok
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.BookList());
    }


    @GetMapping("/taken")   //ok
    public ResponseEntity<List<TakenBooksForLibrarian>> getTakenBooks(){
        return ResponseEntity.ok(takenService.getTakenBooksForLibrarian());
    }

    @PostMapping("/giveBook")  //ok
    public ResponseEntity giveBook(@RequestBody TakenDTO book) throws ParseExceuser_roleption, CustomException {
        int code = takenService.giveBook(book);

        if(code == 404){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/topBooks")
    public ResponseEntity<List<StatisticBookDTO>> getTopBooks(){
        return ResponseEntity.ok(takenService.getBookStatistic());
    }

    @GetMapping("/topEBooks")
    public ResponseEntity<List<StatisticEBookDTO>> getTopEBooks(){
        return ResponseEntity.ok(takenService.getEBookStatistic());
    }

    @GetMapping("/topViewedEBooks")
    public ResponseEntity<List<StatisticEBookDTO>> getTopViewedEBooks(){
        return ResponseEntity.ok(takenService.getViewedEBookStatistic());
    }

    @GetMapping("/deleteBook/{book_id}")
    public ResponseEntity deleteBook(@PathVariable int book_id){
        bookService.deleteBook(book_id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/students")   //ok
    public ResponseEntity<List<StudentsDTO>> getStudents(){
        return ResponseEntity.ok(userService.getStudents());
    }


    @PostMapping("/takeBook")
    public ResponseEntity takeBook(@RequestBody TakenDTO book) throws ParseException, CustomException {
        int code = takenService.takeBook(book);

        if(code == 404){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/bookQuantity")
    public ResponseEntity getBookQuantity(){
        return ResponseEntity.ok(bookService.getBookQuantity());
    }

    @GetMapping("/eBookQuantity")
    public ResponseEntity getEBookQuantity(){
        return ResponseEntity.ok(bookService.getEBookRepository());
    }

    @GetMapping("/takenHistory")
    public ResponseEntity getTakenHistory(){
        return ResponseEntity.ok(takenService.getTakenHistory());
    }











}
