package com.epam.valevataya.task5.command;

import com.epam.valevataya.task5.exception.ConnectionException;
import jakarta.servlet.http.HttpServletRequest;

public interface Command {
  String execute(HttpServletRequest request) throws ConnectionException;
}