package com.epam.valevataya.controller;

import java.io.*;

import com.epam.valevataya.command.Command;
import com.epam.valevataya.command.CommandType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"*.do"})
public class AuthServlet extends HttpServlet {

  public void init() {
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    String requestUri = request.getRequestURI();
    Command command = CommandType.define(requestUri);
    String page = null;
    try {
      page = command.execute(request);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    request.getRequestDispatcher(page).forward(request, response);
  }

  public void destroy() {
  }
}