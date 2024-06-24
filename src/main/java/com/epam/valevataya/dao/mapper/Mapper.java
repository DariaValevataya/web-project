package com.epam.valevataya.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<R> {
  R mapper(ResultSet resultSet) throws SQLException;
}
