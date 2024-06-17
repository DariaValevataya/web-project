package com.epam.valevataya.task5.validation.impl;

import com.epam.valevataya.task5.validation.AuthValidation;

public class AuthValidationImpl implements AuthValidation {
  public static final String LOGIN_REGEX = "\\w{6,10}";
  public static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}";

  @Override
  public boolean loginValidation(String login) {
    return login.matches(LOGIN_REGEX);
  }

  @Override
  public boolean passwordValidation(String password) {
    return password.matches(PASSWORD_REGEX);
  }
}
