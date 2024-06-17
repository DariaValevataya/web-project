package com.epam.valevataya.task5.command.impl;

import com.epam.valevataya.task5.command.Command;
import com.epam.valevataya.task5.command.PagePath;
import com.epam.valevataya.task5.command.RequestParameter;
import com.epam.valevataya.task5.model.User;
import com.epam.valevataya.task5.service.UserService;
import com.epam.valevataya.task5.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SignupCommand implements Command {
  UserService userService = new UserServiceImpl();

  @Override
  public String execute(HttpServletRequest request) {
    String username = request.getParameter(RequestParameter.USERNAME);
    String password = request.getParameter(RequestParameter.PASSWORD);
    String confirmPassword = request.getParameter(RequestParameter.CONFIRM_PASSWORD);
    String pageResult;
    if (userService.comparePasswords(password, confirmPassword) && userService.checkUserByUsernameAndPassword(username, password)) {
      userService.createUser(new User(username, password));
      pageResult = PagePath.LOGIN_PAGE;
    } else {
      pageResult = PagePath.SIGNUP_PAGE;
    }
    return pageResult;
  }
}
