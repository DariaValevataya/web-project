package com.epam.valevataya.validation.impl;

import com.epam.valevataya.validation.AuthValidation;

public class AuthValidationImpl implements AuthValidation {
  public static final String FIRSTNAME_REGEX = "([A-Z]|[А-Я])([a-z]|[а-я]){1,15}";
  public static final String LASTNAME_REGEX = "([A-Z]|[А-Я])([a-z]|[а-я]){1,15}";
  public static final String PHONE_REGEX = "\\+375 (44|29|33|25) [0-9]{3}-[0-9]{2}-[0-9]{2}";
  public static final String EMAIL_REGEX = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9.]+$";
  public static final String LOGIN_REGEX = "\\w{6,10}";
  public static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}";

  @Override
  public boolean firstnameValidation(String firstname) {
    return firstname.matches(FIRSTNAME_REGEX);
  }

  @Override
  public boolean lastnameValidation(String lastname) {
    return lastname.matches(LASTNAME_REGEX);
  }

  @Override
  public boolean phoneValidation(String phone) {
    return phone.matches(PHONE_REGEX);
  }

  @Override
  public boolean emailValidation(String email) {
    return email.matches(EMAIL_REGEX);
  }

  @Override
  public boolean loginValidation(String login) {
    return login.matches(LOGIN_REGEX);
  }

  @Override
  public boolean passwordValidation(String password) {
    return password.matches(PASSWORD_REGEX);
  }
}
