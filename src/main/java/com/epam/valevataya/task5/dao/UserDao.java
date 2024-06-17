package com.epam.valevataya.task5.dao;

import com.epam.valevataya.task5.model.User;
import com.epam.valevataya.task5.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface UserDao {
  public static final Logger logger = LogManager.getLogger();
  boolean checkByUsernameAndPassword(String username, String password);
  boolean authenticate(String username, String password);

  List<User> findAll();

  User findUserById(int id);

  boolean delete(User user);

  boolean deleteById(int id);

  boolean save(User user);

  User update(User user);

  default void close(Statement statement) {
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      logger.warn("Statement not closed");
    }
  }

  default void close(Connection connection) {
      if (connection != null) {
        ConnectionPool.getInstance().releaseConnection(connection);
      }
  }

  default void close(ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException e) {
      logger.warn("ResultSet not closed");
    }
  }
}
