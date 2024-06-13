package com.epam.valevataya.task5.command;

import com.epam.valevataya.task5.exception.ConnectionException;
import com.epam.valevataya.task5.model.User;
import com.epam.valevataya.task5.service.UserService;
import com.epam.valevataya.task5.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SigninCommand implements Command{
  UserService userService = new UserServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws ConnectionException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String pageResult;
    if (!userService.checkUserByUsernameAndPassword(username, password)) {
      userService.createUser(new User(username, password));
      pageResult = "pages/login.jsp";
    } else {
      pageResult = "index.jsp";
    }
    return pageResult;
  }
}
