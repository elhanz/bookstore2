package com.example.bookstore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.bookstore.models.BookRequest;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String year_of_publication;
    private String country;
    private String genres;
    private BigInteger cost;


    public Book(BookRequest bookRequest) {
        this.name = bookRequest.getName();
        this.cost = bookRequest.getCost();
    }

    public Book(String name, BigInteger cost) {
        this.name = name;
        this.cost = cost;
    }
}
