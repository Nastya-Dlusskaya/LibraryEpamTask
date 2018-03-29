package by.epam.library.util.builder;

import by.epam.library.model.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherBuilder implements Builder {

    private static final String ID_PUBLISHER = "id_publisher";
    private static final String NAME_PUBLISHER = "name_publisher";

    @Override
    public Publisher buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID_PUBLISHER);
        String name = resultSet.getString(NAME_PUBLISHER);
        return new Publisher(id, name);
    }
}
