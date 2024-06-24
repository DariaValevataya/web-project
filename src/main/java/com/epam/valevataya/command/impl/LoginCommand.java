package com.epam.valevataya.command.impl;

import com.epam.valevataya.command.RequestParameter;
import com.epam.valevataya.service.UserService;
import com.epam.valevataya.service.impl.UserServiceImpl;
import com.epam.valevataya.command.Command;
import com.epam.valevataya.command.PagePath;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
  UserService userService = new UserServiceImpl();

  @Override
  public String execute(HttpServletRequest request) {
    String login = request.getParameter(RequestParameter.LOGIN);
    String password = request.getParameter(RequestParameter.PASSWORD);
    String pageResult;
    if (userService.authenticateByLogin(login, password)) {
      request.getSession().setAttribute("login", login);
      pageResult = PagePath.RESOURCE_PAGE;
    } else {
      pageResult = PagePath.LOGIN_PAGE;
    }
    return pageResult;
  }
}
