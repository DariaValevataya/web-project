package com.epam.valevataya.task5.validation;

public interface AuthValidation {
  boolean loginValidation(String login);
  boolean passwordValidation(String password);

}
