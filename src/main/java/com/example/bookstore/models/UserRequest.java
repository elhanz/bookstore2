package com.example.bookstore.models;

import com.example.bookstore.Roles.Role;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;

@Data
@ToString
public class UserRequest {
    private Integer id;
    private String email;
    private String password;
    private String nickname;
private Collection <Role> roles =new ArrayList<>();
}
