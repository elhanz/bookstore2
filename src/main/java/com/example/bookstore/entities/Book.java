package com.example.bookstore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String author;
    private int year_of_publication;
    private String country;
    private String genres;
    private double cost;

    public Book(String name,String description, String author, int year_of_publication, String country, String genres, double cost) {
        this.name = name;
        this.description=description;
        this.author = author;
        this.year_of_publication = year_of_publication;
        this.country = country;
        this.genres = genres;
        this.cost = cost;
    }
}
