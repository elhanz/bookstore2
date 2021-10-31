package com.example.bookstore.services;

import java.math.BigInteger;
import java.util.Date;

import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Token;
import com.example.bookstore.entities.User;
import com.example.bookstore.helper.ValidateHelper;
import com.example.bookstore.models.BookRequest;
import com.example.bookstore.models.UserRequest;
import com.example.bookstore.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    public boolean create(BookRequest request) {
//        request.setDate(new Date());
//        bookRepository.save(new Book(request));
//        return true;
//    }
    public boolean saveBook(BookRequest bookRequest) {

        Book byName = bookRepository.findByName(bookRequest.getName());
        if (byName != null) {
            return false;
        }
      Book book = new Book(bookRequest.getName(),bookRequest.getCost());
        bookRepository.save(book);
        return true;
    }
    public boolean deleteBook(String name) {
        Book book = bookRepository.findByName(name);
        bookRepository.delete(book);
        return true;
    }
    public void updateBook(String name, BigInteger cost) {
        Book book = bookRepository.findByName(name);
        book.setCost(cost);
        bookRepository.save(book);
    }
    public Book getBook(String name) {
        return (bookRepository.findByName(name));
    }
}
