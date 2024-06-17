package com.epam.valevataya.task5.service;

import com.epam.valevataya.task5.model.User;

import java.util.List;

public interface UserService {
  boolean checkUserByUsernameAndPassword(String name, String pass);

  boolean comparePasswords(String password, String confirmPassword);

  boolean authenticate(String name, String pass);

  boolean createUser(User user);

  public List<User> viewAll();

}
