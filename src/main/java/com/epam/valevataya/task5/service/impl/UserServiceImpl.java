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
  public boolean checkUserByLoginAndPassword(String login, String pass) {
    boolean check = false;
    if (validator.loginValidation(login) && validator.passwordValidation(pass)) {
      String encodedPassword = encoder.encode(pass);
      check = userDao.checkByLoginAndPassword(login, encodedPassword);
    }
    return check;
  }

  @Override
  public boolean checkUserByEmailAndPassword(String email, String pass) {
    boolean check = false;
    if (validator.emailValidation(email) && validator.passwordValidation(pass)) {
      String encodedPassword = encoder.encode(pass);
      check = userDao.checkByEmailAndPassword(email, encodedPassword);
    }
    return check;
  }

  @Override
  public boolean comparePasswords(String password, String confirmPassword) {
    return password.equals(confirmPassword);
  }

  @Override
  public boolean authenticateByLogin(String login, String pass) {
    boolean auth = false;
    if (validator.loginValidation(login) && validator.passwordValidation(pass)) {
      String encodedPassword = encoder.encode(pass);
      auth = userDao.authenticateByLogin(login, encodedPassword);
    }
    return auth;
  }

  @Override
  public boolean authenticateByEmail(String email, String pass) {
    boolean auth = false;
    if (validator.loginValidation(email) && validator.passwordValidation(pass)) {
      String encodedPassword = encoder.encode(pass);
      auth = userDao.authenticateByEmail(email, encodedPassword);
    }
    return auth;
  }

  @Override
  public boolean createUser(User user) {
    String encodedPassword = encoder.encode(user.getPassword());
    return userDao.save(new User(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getLogin(), encodedPassword));
  }

  @Override
  public List<User> viewAll() {
    return userDao.findAll();
  }

}
