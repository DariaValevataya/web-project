package com.epam.valevataya.task5.command;

import java.util.Arrays;

public enum CommandType {
  LOGIN(new LoginCommand()),
  SIGNIN(new SigninCommand()),
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
    String cmdStr = cmdStrDo.split("\\.")[0];

    return Arrays.stream(CommandType.values())
            .filter(e -> e.name().equals(cmdStr.toUpperCase()))
            .findFirst()
            .orElse(CommandType.EMPTY)
            .getCommand();
  }
}
