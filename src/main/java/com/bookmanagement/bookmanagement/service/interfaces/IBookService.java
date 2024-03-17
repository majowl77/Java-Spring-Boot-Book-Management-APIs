package com.bookmanagement.bookmanagement.service.interfaces;

import com.bookmanagement.bookmanagement.model.Book;

public interface IBookService {
    public Book getSingleBook(Integer id);

    void updateBook(Book book, Integer id);

    void updateBookTitle(String title, Integer id);

    void deleteBook(Integer id);
}
