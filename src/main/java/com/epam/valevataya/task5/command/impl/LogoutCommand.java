package com.epam.valevataya.task5.command.impl;

import com.epam.valevataya.task5.command.Command;
import com.epam.valevataya.task5.command.PagePath;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command {
  @Override
  public String execute(HttpServletRequest request) {
    HttpSession session = request.getSession();
    if (session != null) {
      session.invalidate();
    }
    return PagePath.LOGIN_PAGE;
  }
}
