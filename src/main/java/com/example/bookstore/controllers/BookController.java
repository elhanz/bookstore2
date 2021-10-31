package com.example.bookstore.controllers;

import com.example.bookstore.entities.Book;
import com.example.bookstore.models.BookRequest;
import com.example.bookstore.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


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
    public ResponseEntity updateCost(@RequestParam String name, double cost) {
        bookService.updateCost(name, cost);
        return ResponseEntity.ok("Cost is Updated");
    }
    @PostMapping("/updateGenre")
    public ResponseEntity updateGenre(@RequestParam String name, String genre) {
        bookService.updateGenre(name, genre);
        return ResponseEntity.ok("Genre is Updated");
    }
    @PostMapping("/updateAuthor")
    public ResponseEntity updateAuthor(@RequestParam String name, String author) {
        bookService.updateAuthor(name, author);
        return ResponseEntity.ok("Author is Updated");
    }
    @PostMapping("/updateCountry")
    public ResponseEntity updateCountry(@RequestParam String name, String country) {
        bookService.updateCountry(name, country);
        return ResponseEntity.ok("Country is Updated");
    }
    @PostMapping("/updateYear")
    public ResponseEntity updateYear(@RequestParam String name, int year_of_publication ) {
        bookService.updateYear(name, year_of_publication);
        return ResponseEntity.ok("Year is Updated");
    }
    @PostMapping("/updateDescription")
    public ResponseEntity updateDescription(@RequestParam String name, String description ) {
        bookService.updateDescription(name, description);
        return ResponseEntity.ok("Description is Updated");
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

