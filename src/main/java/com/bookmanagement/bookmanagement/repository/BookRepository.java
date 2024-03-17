package com.bookmanagement.bookmanagement.repository;


import com.bookmanagement.bookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                     // JpaRepository<Entity, Entity Primary Key dat type>
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
}
