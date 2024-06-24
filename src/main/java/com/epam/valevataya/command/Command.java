package com.epam.valevataya.command;

import jakarta.servlet.http.HttpServletRequest;

public interface Command {
  String execute(HttpServletRequest request);
}