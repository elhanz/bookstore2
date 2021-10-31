package com.example.bookstore.repository;

import com.example.bookstore.entities.Token;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Token findByToken(String token);
}
