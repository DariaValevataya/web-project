package com.epam.valevataya.task5.dao;

import com.epam.valevataya.task5.exception.ConnectionException;
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
  boolean checkByUsernameAndPassword(String username, String password) throws ConnectionException;

  List<User> findAll() throws ConnectionException;

  User findUserById(int id) throws ConnectionException;

  boolean delete(User user) throws ConnectionException;

  boolean deleteById(int id) throws ConnectionException;

  boolean save(User user) throws ConnectionException;

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

  default void close(Connection connection) throws ConnectionException {
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
