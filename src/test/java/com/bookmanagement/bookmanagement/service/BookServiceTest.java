package com.bookmanagement.bookmanagement.service;

import com.bookmanagement.bookmanagement.model.Book;
import com.bookmanagement.bookmanagement.repository.BookRepository;
import com.bookmanagement.bookmanagement.service.impl.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCreateBook(){

        Book book = new Book();
        book.setTitle("Harry Potter");
        book.setAuthor("J. K. Rowling");
        book.setPrice(BigDecimal.valueOf(23));
        book.setLanguage("english");
        book.setPublication_year(1997);
        book.setQuantity(60);


        when(bookRepository.save(any(Book.class))).thenReturn(book);

        bookService.createNewBook(book);
        verify(bookRepository).save(book);

    }

    @Test
    public void testGetBookById_ExistingBook(){
        // Arrange
        Integer existingBookId = 667;
        Book existingBook = new Book();
        existingBook.setId(existingBookId);
        when(bookRepository.findById(existingBookId)).thenReturn(Optional.of(existingBook));

        // Act
        Book foundBook = bookService.getSingleBook(existingBookId);

        // Assert
        assertNotNull(foundBook);
        assertEquals(existingBookId, foundBook.getId());

    }

    @Test
    public void testGetSingleBook_NonExistingBook() {
        // Arrange
        Integer nonExistingBookId = 89;
        when(bookRepository.findById(nonExistingBookId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> {
            bookService.getSingleBook(nonExistingBookId);
        });
    }
}
