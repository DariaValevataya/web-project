package com.epam.valevataya.pool;

import com.mysql.cj.jdbc.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
  public static final Logger logger = LogManager.getLogger();
  private BlockingQueue<Connection> connections = new LinkedBlockingQueue<>(4);
  private static ConnectionPool instance;

  private ConnectionPool() {
    try {
      DriverManager.registerDriver(new Driver());
    } catch (SQLException e) {
      logger.warn("No connection");
    }

    String url = "jdbc:mysql://localhost:3306/task5";
    Properties properties = new Properties();
    properties.put("user", "root");
    properties.put("password", "root");
    properties.put("autoReconnect", "true");
    properties.put("characterEncoding", "UTF-8");
    properties.put("useUnicode", "true");
    properties.put("useSSl", "true");
    properties.put("useJBCCompliantTimezoneShift", "true");
    properties.put("useLegacyDatetimeCode", "false");
    properties.put("serverTimezone", "UTC");
    properties.put("serverSslCert", "classpath:server.crt");

    for (int i = 0; i < 4; i++) {
      try {
        Connection connection = DriverManager.getConnection(url, properties);
        connections.put(connection);
      } catch (SQLException | InterruptedException e) {
        logger.warn("No connection");
      }
    }
  }

  public static ConnectionPool getInstance() {
    if (instance == null) {
      instance = new ConnectionPool();
    }
    return instance;
  }

  public Connection getConnection() {
    Connection connection = null;
    try {
      connection = connections.take();
    } catch (InterruptedException e) {
      logger.warn("Don't take connection");
    }
    return connection;
  }

  public void releaseConnection(Connection connection) {
    try {
      connections.put(connection);
    } catch (InterruptedException e) {
      logger.warn("Don't put connection");
    }
  }
}