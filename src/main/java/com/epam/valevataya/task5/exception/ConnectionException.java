package com.epam.valevataya.task5.exception;

public class ConnectionException extends Exception {
  public ConnectionException() {}

  public ConnectionException(String message) {
    super(message);
  }

  public ConnectionException(String message, Throwable cause) {
    super(message, cause);
  }

  public ConnectionException(Throwable cause) {
    super(cause);
  }

}
