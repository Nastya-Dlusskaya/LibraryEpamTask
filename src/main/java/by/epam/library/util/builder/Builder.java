package by.epam.library.util.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Builder<T> {
    T buildObject(ResultSet resultSet) throws SQLException;
}
