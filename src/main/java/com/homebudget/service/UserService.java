package com.homebudget.service;

import com.homebudget.model.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);
    User findUserById(int id);
    void saveUser(User user);
    List<String> getUserNames();
}
