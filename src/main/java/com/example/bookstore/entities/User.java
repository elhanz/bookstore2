package com.example.bookstore.entities;


import com.example.bookstore.roles.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
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
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles =new ArrayList<>();
    public User( String nickname,  String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password=password;
    }

}