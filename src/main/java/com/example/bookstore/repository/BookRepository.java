package com.example.bookstore.repository;

import com.example.bookstore.entities.Book;

import com.example.bookstore.entities.Token;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
   Book findByName(String name);
}
