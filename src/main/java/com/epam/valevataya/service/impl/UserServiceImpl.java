package com.epam.valevataya.service.impl;

import com.epam.valevataya.model.User;
import com.epam.valevataya.dao.UserDao;
import com.epam.valevataya.dao.impl.UserDaoImpl;
import com.epam.valevataya.service.UserService;
import com.epam.valevataya.util.encode.PasswordEncoder;
import com.epam.valevataya.validation.AuthValidation;
import com.epam.valevataya.validation.impl.AuthValidationImpl;

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
      System.out.println(check);
    }
    return check;
  }

  @Override
  public boolean checkUserParameters(String firstname, String lastname, String email, String phone) {
    boolean check = false;
    if (validator.firstnameValidation(firstname) && validator.lastnameValidation(lastname) && validator.emailValidation(email) && validator.phoneValidation(phone)) {
      check = true;
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
  public boolean createUser(User user) {
    String encodedPassword = encoder.encode(user.getPassword());
    return userDao.save(new User(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getLogin(), encodedPassword));
  }

  @Override
  public List<User> viewAll() {
    return userDao.findAll();
  }

}
