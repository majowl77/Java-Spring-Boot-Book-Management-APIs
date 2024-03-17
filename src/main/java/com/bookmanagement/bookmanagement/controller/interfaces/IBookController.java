package com.bookmanagement.bookmanagement.controller.interfaces;

import com.bookmanagement.bookmanagement.controller.dto.BookTitleDTO;
import com.bookmanagement.bookmanagement.model.Book;

import java.util.List;

public interface IBookController {
    public List<Book> getAllBooks();
    public Book getSingleBook(Integer id);
    public void createNewBook(Book book);
    public void updateBook(Book book, Integer id);
    public void updateBookTitle(BookTitleDTO bookTitleDTO,Integer id);
    public void deleteBook(Integer id);

}
