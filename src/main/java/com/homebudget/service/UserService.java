package com.homebudget.service;

import com.homebudget.model.User;

import java.util.List;

public interface UserService {
    public User findUserByUsername(String username);
    public void saveUser(User user);
    public List<String> getUserNames();
}
