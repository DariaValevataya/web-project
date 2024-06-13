package com.epam.valevataya.task5.service.impl;

import com.epam.valevataya.task5.dao.UserDao;
import com.epam.valevataya.task5.dao.impl.UserDaoImpl;
import com.epam.valevataya.task5.exception.ConnectionException;
import com.epam.valevataya.task5.model.User;
import com.epam.valevataya.task5.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
  private UserDao userDao = new UserDaoImpl();

  @Override
  public boolean checkUserByUsernameAndPassword(String name, String pass) throws ConnectionException {
    return userDao.checkByUsernameAndPassword(name, pass);
  }

  @Override
  public boolean createUser(User user) throws ConnectionException {
    return userDao.save(user);
  }

  @Override
  public List<User> viewAll() throws ConnectionException {
    return userDao.findAll();
  }

}
