package com.example.bookstore.entities;

import com.example.bookstore.entities.Book;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String nickname;
    private String email;
    private String password;
    @OneToMany
    private List<Book> books;

    public User( final String nickname, final String email,final String password) {
        this.nickname = nickname;
        this.email = email;
        this.password=password;
    }

}