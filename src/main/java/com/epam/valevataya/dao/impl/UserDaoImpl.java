package com.epam.valevataya.dao.impl;

import com.epam.valevataya.dao.ColumnName;
import com.epam.valevataya.dao.mapper.impl.UserMapper;
import com.epam.valevataya.model.User;
import com.epam.valevataya.pool.ConnectionPool;
import com.epam.valevataya.dao.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
  public static final Logger logger = LogManager.getLogger();
  private static final String SELECT_ALL_USERS = "SELECT * FROM users";
  private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?";
  private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
  private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=? AND password=?";
  private static final String ADD_USER = "INSERT INTO users (login, password) values (?, ?)";
  private static final String UPDATE_USER = "UPDATE users SET login = ?, password = ? WHERE id = ?";
  private static final String DELETE_USER = " DELETE FROM users WHERE id = ? ";

  @Override
  public boolean checkByLoginAndPassword(String login, String password) {
    boolean match;
    Connection connection = ConnectionPool.getInstance().getConnection();
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(SELECT_USER_BY_LOGIN_AND_PASSWORD);
      statement.setString(1, login);
      statement.setString(2, password);
      match = statement.execute();
    } catch (SQLException e) {
      logger.warn("User not found");
      throw new RuntimeException(e);
    } finally {
      close(statement);
      close(connection);
    }
    return match;
  }

  @Override
  public boolean authenticateByLogin(String login, String password) {
    boolean match = false;
    Connection connection = ConnectionPool.getInstance().getConnection();
    ResultSet resultSet = null;
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
      statement.setString(1, login);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String pass = resultSet.getString(ColumnName.PASSWORD);
        match = password.equals(pass);
      }
    } catch (SQLException e) {
      logger.warn("User not found");
      throw new RuntimeException(e);
    } finally {
      close(resultSet);
      close(statement);
      close(connection);
    }
    return match;
  }


  @Override
  public List<User> findAll() {
    Connection connection = ConnectionPool.getInstance().getConnection();
    ResultSet resultSet = null;
    PreparedStatement statement = null;
    List<User> users = new ArrayList<>();
    try {
      statement = connection.prepareStatement(SELECT_ALL_USERS);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        User user = new UserMapper().mapper(resultSet);
        users.add(user);
      }
    } catch (SQLException e) {
      logger.warn("User not deleted");
      throw new RuntimeException(e);
    } finally {
      close(resultSet);
      close(statement);
      close(connection);
    }
    return users;
  }

  @Override
  public User findUserById(int id) {
    Connection connection = ConnectionPool.getInstance().getConnection();
    ResultSet resultSet = null;
    PreparedStatement statement = null;
    User user;
    try {
      statement = connection.prepareStatement(SELECT_USER_BY_ID);
      statement.setInt(1, id);
      resultSet = statement.executeQuery();
      user = new UserMapper().mapper(resultSet);
    } catch (SQLException e) {
      logger.warn("User not deleted");
      throw new RuntimeException(e);
    } finally {
      close(resultSet);
      close(statement);
      close(connection);
    }
    return user;
  }

  @Override
  public boolean delete(User user) {
    boolean done = false;
    Connection connection = ConnectionPool.getInstance().getConnection();
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(DELETE_USER);
      statement.setInt(1, user.getId());
      done = statement.execute();
    } catch (SQLException e) {
      logger.warn("User not deleted");
      throw new RuntimeException(e);
    } finally {
      close(statement);
      close(connection);
    }
    return done;
  }

  @Override
  public boolean deleteById(int id) {
    boolean done = false;
    Connection connection = ConnectionPool.getInstance().getConnection();
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(DELETE_USER);
      statement.setInt(1, id);
      done = statement.execute();
    } catch (SQLException e) {
      logger.warn("User not deleted");
      throw new RuntimeException(e);
    } finally {
      close(statement);
      close(connection);
    }
    return done;
  }

  @Override
  public boolean save(User user) {
    boolean done = false;
    Connection connection = ConnectionPool.getInstance().getConnection();
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(ADD_USER);
      //statement.setString(1, user.getUsername());
      statement.setString(2, user.getPassword());
      done = statement.execute();
    } catch (SQLException e) {
      logger.warn("User not added");
      throw new RuntimeException(e);
    } finally {
      close(statement);
      close(connection);
    }
    return done;
  }

  @Override
  public User update(User user) {
    return null;
  }
}
