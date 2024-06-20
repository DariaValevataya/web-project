package com.epam.valevataya.task5.validation;

public interface AuthValidation {
  boolean firstnameValidation(String firstname);
  boolean lastnameValidation(String lastname);
  boolean phoneValidation(String phone);
  boolean emailValidation(String email);
  boolean loginValidation(String login);
  boolean passwordValidation(String password);

}
