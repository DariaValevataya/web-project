package com.epam.valevataya.command.impl;

import com.epam.valevataya.command.Command;
import com.epam.valevataya.command.PagePath;
import jakarta.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
  @Override
  public String execute(HttpServletRequest request) {
    return PagePath.EMPTY_PAGE;
  }
}
