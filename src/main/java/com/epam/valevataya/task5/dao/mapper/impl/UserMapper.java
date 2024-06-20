package com.epam.valevataya.task5.dao.mapper.impl;

import com.epam.valevataya.task5.dao.ColumnName;
import com.epam.valevataya.task5.dao.mapper.Mapper;
import com.epam.valevataya.task5.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
  @Override
  public User mapper(ResultSet resultSet) throws SQLException {
    int id = resultSet.getInt(ColumnName.ID);
    String username = resultSet.getString(ColumnName.LOGIN);
    String password = resultSet.getString(ColumnName.PASSWORD);
    User user = null;//new User(id, username, password);
    return user;
  }
}
