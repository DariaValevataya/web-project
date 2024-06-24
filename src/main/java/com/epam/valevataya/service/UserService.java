package com.epam.valevataya.service;

import com.epam.valevataya.model.User;

import java.util.List;

public interface UserService {
  boolean checkUserByLoginAndPassword(String login, String pass);
  boolean checkUserParameters(String firstname, String lastname, String email, String phone);

  boolean comparePasswords(String password, String confirmPassword);

  boolean authenticateByLogin(String login, String pass);

  boolean createUser(User user);

  public List<User> viewAll();

}
