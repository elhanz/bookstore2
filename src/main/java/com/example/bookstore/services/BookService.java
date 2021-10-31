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


    public boolean saveBook(BookRequest bookRequest) {
        Book byName = bookRepository.findByName(bookRequest.getName());
        if (byName != null) {
            return false;
        }
        Book book = new Book(bookRequest.getName(),bookRequest.getAuthor(),bookRequest.getYear_of_publication(),bookRequest.getCountry(),bookRequest.getGenres(),bookRequest.getCost());
        bookRepository.save(book);
        return true;

    }
    public boolean deleteBook(String name) {
        Book book = bookRepository.findByName(name);
        bookRepository.delete(book);
        return true;
    }
    public void updateCost(String name, double cost) {
        Book book = bookRepository.findByName(name);
        book.setCost(cost);
        bookRepository.save(book);
    }
    public void updateAuthor(String name, String author) {
        Book book = bookRepository.findByName(name);
        book.setAuthor(author);
        bookRepository.save(book);
    }
    public void updateGenre(String name, String genre) {
        Book book = bookRepository.findByName(name);
        book.setGenres(genre);
        bookRepository.save(book);
    }
    public void updateCountry(String name, String country) {
        Book book = bookRepository.findByName(name);
        book.setCountry(country);
        bookRepository.save(book);
    }
    public void updateYear(String name, int year_of_publication) {
        Book book = bookRepository.findByName(name);
        book.setYear_of_publication(year_of_publication);
        bookRepository.save(book);
    }
    public Book getBook(String name) {
        return (bookRepository.findByName(name));
    }
}
