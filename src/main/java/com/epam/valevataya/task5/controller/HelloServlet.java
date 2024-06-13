package com.epam.valevataya.task5.controller;

import java.io.*;

import com.epam.valevataya.task5.command.Command;
import com.epam.valevataya.task5.command.CommandType;
import com.epam.valevataya.task5.exception.ConnectionException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/hello-servlet", "*.do"})
public class HelloServlet extends HttpServlet {

  public void init() {
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    String requestUri = request.getRequestURI();
    Command command = CommandType.define(requestUri);
    String page = null;
    try {
      page = command.execute(request);
    } catch (ConnectionException e) {
      throw new RuntimeException(e);
    }
    request.getRequestDispatcher(page).forward(request, response);
  }

  public void destroy() {
  }
}