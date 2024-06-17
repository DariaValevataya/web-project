package com.epam.valevataya.task5.command.impl;

import com.epam.valevataya.task5.command.Command;
import com.epam.valevataya.task5.command.PagePath;
import jakarta.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
  @Override
  public String execute(HttpServletRequest request) {
    return PagePath.EMPTY_PAGE;
  }
}
