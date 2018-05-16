package by.epam.library.util.builder;

import by.epam.library.model.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherBuilder implements Builder {

    @Override
    public Publisher buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Publisher.ID_PUBLISHER);
        String name = resultSet.getString(Publisher.NAME_PUBLISHER);
        return new Publisher(id, name);
    }
}
