package com.example.bookstore.controllers;

import com.example.bookstore.entities.User;
import com.example.bookstore.servicesIntefaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserControl {
    private final UserServiceInterface userServiceInterface;


}
