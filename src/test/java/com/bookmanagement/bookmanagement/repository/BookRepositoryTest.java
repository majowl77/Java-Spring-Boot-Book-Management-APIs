package com.bookmanagement.bookmanagement.repository;

import com.bookmanagement.bookmanagement.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

//    @BeforeEach
//    public void setUp(){
//        Book alice = new Book(4,"Alice's Adventures in Wonderland","Lewis Carroll", 1865, "english", BigDecimal.valueOf(23), 200);
//        bookRepository.save(alice);
//    }

    @AfterEach
    public void tearDown(){
        bookRepository.deleteById(5);
    }

    @Test
    public void findAll_Books_BooksList(){
        List<Book> bookList = bookRepository.findAll();
        System.out.println(bookList);
    }

//    @Test
//    public void findById_validId_correctBook(){
//        Optional<Book> bookOptional = bookRepository.findById(2);
//        boolean isPresent = bookOptional.isPresent();
//        if(isPresent) System.out.println(" **** the value exist ****"+ bookOptional.get().getTitle());
//        System.out.println("the value is not exist");
//    }

//    @Test
//    public void findByTitle_validTitle_correctBook(){
//        Optional<Book> bookOptional = bookRepository.findByTitle("Moby Dick");
//        assertTrue(bookOptional.isPresent());
//        System.out.println(bookOptional.get());
//        assertEquals("english", bookOptional.get().getLanguage());
//    }

};