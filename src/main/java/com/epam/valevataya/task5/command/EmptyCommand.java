package com.epam.valevataya.task5.command;

import jakarta.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command{
  @Override
  public String execute(HttpServletRequest request) {
    return "pages/empty.jsp";
  }
}
