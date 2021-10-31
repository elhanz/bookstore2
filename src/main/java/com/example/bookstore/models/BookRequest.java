package com.example.bookstore.models;

import lombok.Data;


@Data
public class BookRequest {

    private String name;
    private String description;
    private String author;
    private int year_of_publication;
    private String country;
    private String genres;
    private double cost;

}