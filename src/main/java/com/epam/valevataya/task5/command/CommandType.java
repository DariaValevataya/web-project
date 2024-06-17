package com.epam.valevataya.task5.command;

import com.epam.valevataya.task5.command.impl.EmptyCommand;
import com.epam.valevataya.task5.command.impl.LoginCommand;
import com.epam.valevataya.task5.command.impl.LogoutCommand;
import com.epam.valevataya.task5.command.impl.SignupCommand;

import java.util.Arrays;

public enum CommandType {
  LOGIN(new LoginCommand()),
  SIGNUP(new SignupCommand()),
  LOGOUT(new LogoutCommand()),
  EMPTY(new EmptyCommand());
  private Command command;

  CommandType(Command command) {
    this.command = command;
  }

  public Command getCommand() {
    return command;
  }

  public static Command define(String requestUri) {
    String [] parts = requestUri.split("/");
    String cmdStrDo =  parts[parts.length-1];
    System.out.println(requestUri);
    String cmdStr = cmdStrDo.split("\\.")[0];

    return Arrays.stream(CommandType.values())
            .filter(e -> e.name().equals(cmdStr.toUpperCase()))
            .findFirst()
            .orElse(CommandType.EMPTY)
            .getCommand();
  }
}
