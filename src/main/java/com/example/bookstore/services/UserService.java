package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Token;
import com.example.bookstore.entities.User;
import com.example.bookstore.helper.TokenHelper;
import com.example.bookstore.helper.ValidateHelper;
import com.example.bookstore.models.LoginRequest;
import com.example.bookstore.models.UserRequest;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.TokenRepository;
import com.example.bookstore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TokenRepository tokenRepository;


    public boolean saveUser(UserRequest userRequest) {
        if (!ValidateHelper.validate(userRequest.getEmail())) {
            return false;
        }
        User byEmail = userRepository.findByEmail(userRequest.getEmail());
        if (byEmail != null) {
            return false;
        }
        User user = new User(userRequest.getNickname(), userRequest.getEmail(), userRequest.getPassword());
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(String token) {
        Token token1 = tokenRepository.findByToken(token);
        User user = userRepository.findByEmail(TokenHelper.getEmailByToken(token));
        userRepository.delete(user);
        tokenRepository.delete(token1);
        return true;
    }

    public boolean login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        {
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
            return false;
        }
    }

    public boolean addBooksToUser(Integer userId, List<Integer> bookIds) {
        Optional<User> userOptional = userRepository.findById(userId.longValue());
        User user = userOptional.orElse(null);
        if (user == null) {
            return false;
        }

        List<Book> books = new ArrayList<>();
        bookIds.forEach(id -> bookRepository.findById(id.longValue()).ifPresent(p -> books.add(p)));
        user.setBooks(books);
        userRepository.save(user);
        return true;
    }

    public void addToken(String token) {
        Token token1 = new Token(token);
        tokenRepository.save(token1);
    }

    public boolean deleteToken(String token) {
        Token token1 = tokenRepository.findByToken(token);
        tokenRepository.delete(token1);
        return true;
    }

    public void updatePassword(String token, String password) {
        User user = userRepository.findByEmail(TokenHelper.getEmailByToken(token));
        user.setPassword(password);
        userRepository.save(user);
    }

    public void updateNickname(String token, String nickname) {
        User user = userRepository.findByEmail(TokenHelper.getEmailByToken(token));
        user.setNickname(nickname);
        userRepository.save(user);
    }

    public User getUsers(Integer id) {
        return userRepository.findById(id.longValue()).orElse(null);
    }

    public User getUsersByToken(String token) {
        return userRepository.findByEmail(tokenRepository.findByToken(token).getToken());
    }
}
