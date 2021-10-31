package com.example.bookstore.models;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class BookRequest {
    private String name;
    private BigInteger cost;
    private Date date;
}