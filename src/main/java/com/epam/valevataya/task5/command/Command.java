package com.epam.valevataya.task5.command;

import jakarta.servlet.http.HttpServletRequest;

public interface Command {
  String execute(HttpServletRequest request) ;
}