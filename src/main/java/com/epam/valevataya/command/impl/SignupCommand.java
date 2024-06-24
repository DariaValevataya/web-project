package com.epam.valevataya.command.impl;

import com.epam.valevataya.command.Command;
import com.epam.valevataya.command.PagePath;
import com.epam.valevataya.command.RequestParameter;
import com.epam.valevataya.model.User;
import com.epam.valevataya.service.UserService;
import com.epam.valevataya.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SignupCommand implements Command {
  UserService userService = new UserServiceImpl();

  @Override
  public String execute(HttpServletRequest request) {
    String firstname = request.getParameter(RequestParameter.FIRSTNAME);
    String lastname = request.getParameter(RequestParameter.LASTNAME);
    String phone = request.getParameter(RequestParameter.PHONE);
    String email = request.getParameter(RequestParameter.EMAIL);
    String login = request.getParameter(RequestParameter.LOGIN);
    String password = request.getParameter(RequestParameter.PASSWORD);
    String confirmPassword = request.getParameter(RequestParameter.CONFIRM_PASSWORD);
    String pageResult;
    if (userService.comparePasswords(password, confirmPassword) && !userService.checkUserByLoginAndPassword(login, password) && userService.checkUserParameters(firstname, lastname, email, phone)) {
      User user = new User(firstname, lastname, phone, email, login, password);
      userService.createUser(user);
      pageResult = PagePath.LOGIN_PAGE;
    } else {
      pageResult = PagePath.SIGNUP_PAGE;
    }
    return pageResult;
  }
}
