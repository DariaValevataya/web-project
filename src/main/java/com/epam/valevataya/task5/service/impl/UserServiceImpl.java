package com.epam.valevataya.task5.service.impl;

import com.epam.valevataya.task5.command.impl.SignupCommand;
import com.epam.valevataya.task5.dao.UserDao;
import com.epam.valevataya.task5.dao.impl.UserDaoImpl;
import com.epam.valevataya.task5.model.User;
import com.epam.valevataya.task5.service.UserService;
import com.epam.valevataya.task5.util.encode.PasswordEncoder;
import com.epam.valevataya.task5.validation.AuthValidation;
import com.epam.valevataya.task5.validation.impl.AuthValidationImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
  private AuthValidation validator = new AuthValidationImpl();
  private PasswordEncoder encoder = new PasswordEncoder();
  private UserDao userDao = new UserDaoImpl();


  @Override
  public boolean checkUserByUsernameAndPassword(String name, String pass) {
    if (validator.loginValidation(name) && validator.passwordValidation(pass)) {
      String encodedPassword = encoder.encode(pass);
      System.out.println(encodedPassword);
      return userDao.checkByUsernameAndPassword(name, encodedPassword);
    }
    return false;
  }

  @Override
  public boolean comparePasswords(String password, String confirmPassword) {
    return password.equals(confirmPassword);
  }

  @Override
  public boolean authenticate(String name, String pass) {
    if (validator.loginValidation(name) && validator.passwordValidation(pass)) {
      String encodedPassword = encoder.encode(pass);
      System.out.println(encodedPassword);
      return userDao.authenticate(name, encodedPassword);
    }
    return false;
  }

  @Override
  public boolean createUser(User user) {
    String encodedPassword = encoder.encode(user.getPassword());
    return userDao.save(new User(user.getUsername(), encodedPassword));
  }

  @Override
  public List<User> viewAll() {
    return userDao.findAll();
  }

}
