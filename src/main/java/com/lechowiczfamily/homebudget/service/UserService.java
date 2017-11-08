package com.lechowiczfamily.homebudget.service;

import com.lechowiczfamily.homebudget.model.User;

public interface UserService {
    public User findUserByUsername(String username);
    public void saveUser(User user);
}
