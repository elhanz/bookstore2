package com.example.bookstore.servicesIntefaces;

import com.example.bookstore.entities.User;
import com.example.bookstore.roles.Role;

import java.util.List;

public interface UserServiceInterface
{
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email,String  roleName);
    User getUser (String email);
     List<User> getUsers();

}
