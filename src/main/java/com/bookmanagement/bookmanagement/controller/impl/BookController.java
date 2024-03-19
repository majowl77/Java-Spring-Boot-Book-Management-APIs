package com.bookmanagement.bookmanagement.controller.impl;

import com.bookmanagement.bookmanagement.controller.dto.BookTitleDTO;
import com.bookmanagement.bookmanagement.controller.interfaces.IBookController;
import com.bookmanagement.bookmanagement.model.Book;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import com.bookmanagement.bookmanagement.service.interfaces.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController implements IBookController {

    // we use this to have access to our DB data, and it needs to be autowired
    @Autowired
    BookRepository bookRepository;

    @Autowired
    IBookService bookService;


    // --------------- GET all the books, and byID ------------

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK) // 200
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)// 200
    public Book getSingleBook(@PathVariable(name = "id") Integer id){
        return bookService.getSingleBook(id);
    }


    // --------------- POST create a new book ------------

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public void createNewBook(@RequestBody @Valid Book book){
        bookService.createNewBook(book);
    }


    // --------------- PUT update some info of an existed book ------------

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void updateBook(@RequestBody @Valid Book book, @PathVariable(name = "id") Integer id){
        bookService.updateBook(book, id);
    }

    // --------------- PATCH updating a single column or a single attribute ------------
    @PatchMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)// 204
    public void updateBookTitle(@RequestBody @Valid BookTitleDTO bookTitleDTO, @PathVariable Integer id){
        bookService.updateBookTitle(bookTitleDTO.getTitle(), id);

    }


    // --------------- DELETE an existing book ------------
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }



}
