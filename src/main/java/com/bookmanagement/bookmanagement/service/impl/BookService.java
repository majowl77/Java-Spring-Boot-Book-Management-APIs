package com.bookmanagement.bookmanagement.service.impl;


import com.bookmanagement.bookmanagement.model.Book;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import com.bookmanagement.bookmanagement.service.interfaces.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    public Book getSingleBook(Integer id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()) return null;
        return bookOptional.get();
    }

    public void updateBook(Book book, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()) return;
        /*
        an optional step we can use book.setId(id);
        to ensure that the id of the book object remains consistent
        with the id passed as a parameter to the method.
        */
        bookRepository.save(book);
    }

    public void updateBookTitle(String title, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()) return;
        Book book = bookOptional.get();
        book.setTitle(title);
        bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()) return;
        bookRepository.deleteById(id);
    }
}
