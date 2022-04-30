package com.example.librarydemo.services;

import com.example.librarydemo.DTO.BookDTO;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.models.Category;
import com.example.librarydemo.repository.BookRepository;
import com.example.librarydemo.repository.CategoryRepository;
import com.example.librarydemo.repository.EBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EBookRepository eBookRepository;


    public List<Book> BookList(){
        return (List<Book>)bookRepository.findAll();
    }

    public List<Book> InLibraryBookList(){
        return (List<Book>)bookRepository.getInLibraryBooks();
    }


    public void creatBook(Book book){
        book.setInLibrary(true);
        bookRepository.save(book);
    }


    public Book findBookById(int id){
        return bookRepository.findById(id).get();
    }
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public void editBook(BookDTO bookDTO){
        Category category = categoryRepository.getCategoryByName(bookDTO.getCategory());

        Book book = bookRepository.findById(bookDTO.getId()).get();

        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(category);
        book.setDescription(bookDTO.getDescription());
//        book.setPhoto(bookDTO.getPhoto());
        book.setReleaseYear(bookDTO.getReleaseYear());

        bookRepository.save(book);


    }

    public int getBookQuantity(){
        return bookRepository.getBookQuantity();
    }

    public  int getEBookRepository(){
        return eBookRepository.getEBookQuantity();
    }


}
