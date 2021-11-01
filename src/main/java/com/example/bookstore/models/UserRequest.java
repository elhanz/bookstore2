package com.example.bookstore.models;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Data
@ToString
public class UserRequest {
    private Integer id;
    private String email;
    private String password;
    private String nickname;
}
