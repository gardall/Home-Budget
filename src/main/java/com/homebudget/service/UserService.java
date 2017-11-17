package com.homebudget.service;

import com.homebudget.model.User;

public interface UserService {
    public User findUserByUsername(String username);
    public void saveUser(User user);
}
