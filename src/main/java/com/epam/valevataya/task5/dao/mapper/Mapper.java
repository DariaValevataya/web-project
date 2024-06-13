package com.epam.valevataya.task5.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<R> {
  R mapper(ResultSet resultSet) throws SQLException;
}
