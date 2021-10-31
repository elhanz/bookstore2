package com.example.bookstore.controllers;

import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.User;
import com.example.bookstore.models.BookRequest;
import com.example.bookstore.models.UserRequest;
import com.example.bookstore.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

//    @PostMapping
//    public ResponseEntity create(@RequestBody BookRequest book) {
//        bookService.create(book);
//        return ResponseEntity.ok(" ");
//    }
    @PostMapping("/createBook")
    public ResponseEntity create(@RequestBody BookRequest bookRequest) {
        boolean result = bookService.saveBook(bookRequest);
        if (result) {
            return new ResponseEntity("book created", HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body("bad request");
    }
    @PostMapping("/deleteBook")
    public ResponseEntity deleteUser(@RequestParam String name) {
        Book book=bookService.getBook(name);
        if (bookService.deleteBook(name)){
            return ResponseEntity.badRequest().body("book deleted");
        }
        return ResponseEntity.badRequest().body("invalid name");
    }

    @PostMapping("/updateCost")
    public ResponseEntity updateCost(@RequestParam String name, BigInteger cost) {
        bookService.updateBook(name, cost);
        return ResponseEntity.ok("Updated");
    }
    @GetMapping("/getBook")
    public ResponseEntity getUserByName(@RequestParam String name) {
       Book bookRequest = bookService.getBook(name);
        if (bookRequest == null) {
            return new ResponseEntity("Book not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(bookRequest);
    }
}

