package com.epam.valevataya.task5.service;

import com.epam.valevataya.task5.exception.ConnectionException;
import com.epam.valevataya.task5.model.User;

import java.util.List;

public interface UserService {
  boolean checkUserByUsernameAndPassword(String name, String pass) throws ConnectionException;

  boolean createUser(User user) throws ConnectionException;

  public List<User> viewAll() throws ConnectionException;

}
