package com.bookmanagement.bookmanagement.controller.impl;

import com.bookmanagement.bookmanagement.model.Book;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import com.bookmanagement.bookmanagement.service.interfaces.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    // we use this to have access to our DB data, and it needs to be autowired
    @Autowired
    BookRepository bookRepository;

    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getSingleBook(@PathVariable(name = "id") Integer id){
        return bookService.getSingleBook(id);
    }


    // --------------- Post Create a new book ------------
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public void createNewBook(@RequestBody @Valid Book book){
        bookRepository.save(book);
    }


    // --------------- Put update some info of an existed book ------------
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public void updateBook(@RequestBody @Valid Book book, @PathVariable(name = "id") Integer id){
        bookService.updateBook(book, id);
    }


    // Delete


}
