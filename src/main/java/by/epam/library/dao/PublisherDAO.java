package by.epam.library.dao;

import by.epam.library.model.entity.Publisher;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.PublisherBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PublisherDAO extends AbstractDAO {

    private static final String FIND_ALL_PUBLISHER = "SELECT id_publisher, name_publisher FROM publisher";

    public PublisherDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Publisher buildEntity(ResultSet resultSet) throws DAOException {
        try {
            PublisherBuilder publisherBuilder = new PublisherBuilder( );
            return publisherBuilder.buildObject(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage( ), e);
        }
    }

    @Override
    public void save(Object entity) throws DAOException {

    }

    @Override
    public Object findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List findAll() throws DAOException {
        return execute(FIND_ALL_PUBLISHER);
    }
}
