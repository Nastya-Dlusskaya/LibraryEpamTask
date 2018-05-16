package by.epam.library.util.builder;

import by.epam.library.model.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorBuilder implements Builder {

    @Override
    public Author buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Author.ID_AUTHOR);
        String lastName = resultSet.getString(Author.LAST_NAME_AUTHOR);
        String firstName = resultSet.getString(Author.FIRST_NAME_AUTHOR);
        return new Author(id, lastName, firstName);
    }
}
