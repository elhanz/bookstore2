package com.example.bookstore.models;

import lombok.Data;

import java.util.List;

@Data
public class AddBookRequest {
    private Integer userId;
    private List<Integer> bookIds;
}
