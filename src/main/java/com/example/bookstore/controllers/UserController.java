package com.example.bookstore.controllers;

import com.example.bookstore.dto.LoginRequest;
import com.example.bookstore.entities.User;
import com.example.bookstore.helper.TokenHelper;
import com.example.bookstore.helper.ValidateHelper;
import com.example.bookstore.models.AddBookRequest;
import com.example.bookstore.models.UserRequest;
import com.example.bookstore.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserRequest userRequest) {
        boolean result = userService.saveUser(userRequest);
        if (result) {
            return new ResponseEntity("user created", HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body("bad request");
    }

    @GetMapping("/get")
    public ResponseEntity getUserById(@RequestParam Integer id) {
        User userRequest = userService.getUsers(id);
        if (userRequest == null) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userRequest);
    }

    @GetMapping("/email")
    public ResponseEntity checkEmail(@RequestParam String email) {
        return ResponseEntity.ok(ValidateHelper.validate(email));
    }

    @PostMapping("/addBooks")
    public ResponseEntity addBooks(@RequestBody AddBookRequest request) {
        userService.addBooksToUser(request.getUserId(), request.getBookIds());
        return ResponseEntity.ok().body("");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        if (userService.login(loginRequest)) {
            String token = TokenHelper.getToken(loginRequest.getEmail());
            userService.addToken(token, loginRequest.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("incorrect email or password");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestParam String token) {
        User user = userService.getUsersByToken(token);
        if (user != null) {
            userService.deleteToken(token);
            return ResponseEntity.ok("You successfully logout");
        }
        return ResponseEntity.badRequest().body("incorrect token");
    }

    @GetMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam String token) {
        User user = userService.getUsersByToken(token);
        if (userService.deleteUser(token) ) {

            return ResponseEntity.badRequest().body("user deleted");
        }
        return ResponseEntity.badRequest().body("invalid token");
    }

    @PostMapping("/updateNickname")
    public ResponseEntity updateNickname(@RequestParam String token, String nickname) {
        userService.updateNickname(token, nickname);
        return ResponseEntity.ok("Updated");
    }

    @PostMapping("/updatePassword")
    public ResponseEntity updatePassword(@RequestParam String token, String password) {
        userService.updatePassword(token, password);
        return ResponseEntity.ok("Updated");
    }


}
