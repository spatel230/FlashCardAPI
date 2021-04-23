package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface LoginDAO {
    List<User> findAllUser();
    User ifCredentialsMatch(User check);
    User ifUsernameIsTaken(String name);
    User findById(int ID);
    void save(User newUser);
    void deleteUserById(int ID);
}
