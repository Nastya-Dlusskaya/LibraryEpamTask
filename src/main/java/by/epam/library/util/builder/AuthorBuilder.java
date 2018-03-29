package by.epam.library.util.builder;

import by.epam.library.model.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorBuilder implements Builder {

    private static final String ID = "id_author";
    private static final String LAST_NAME = "last_name_author";
    private static final String FIRST_NAME = "first_name_author";

    @Override
    public Author buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);
        String lastName = resultSet.getString(LAST_NAME);
        String firstName = resultSet.getString(FIRST_NAME);
        return new Author(id, lastName, firstName);
    }
}
