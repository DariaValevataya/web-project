package com.epam.valevataya.task5.service;

import com.epam.valevataya.task5.model.User;

import java.util.List;

public interface UserService {
  boolean checkUserByLoginAndPassword(String login, String pass);
  boolean checkUserByEmailAndPassword(String email, String pass);

  boolean comparePasswords(String password, String confirmPassword);

  boolean authenticateByLogin(String login, String pass);
  boolean authenticateByEmail(String email, String pass);

  boolean createUser(User user);

  public List<User> viewAll();

}
