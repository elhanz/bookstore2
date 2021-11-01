package com.example.bookstore.repository;

import com.example.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
   Book findByName(String name);
}
