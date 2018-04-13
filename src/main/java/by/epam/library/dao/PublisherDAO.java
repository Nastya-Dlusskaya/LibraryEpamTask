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
    private static final String FIND_PUBLISHER_BY_ID = "SELECT * FROM library.publisher WHERE id_publisher=?";
    private static final String INSERT_QUERY = "INSERT INTO library.publisher(name_publisher)" +
            " VALUES(?)";
    private static final String UPDATE_QUERY = "UPDATE library.author SET name_publisher=? " +
            "WHERE id_publisher=?";

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
        Publisher publisher = (Publisher) entity;
        Integer publisherId = publisher.getId();
        if(publisherId == null){
            change(INSERT_QUERY, publisher.getName());
        } else{
            change(UPDATE_QUERY, publisher.getName(), publisher.getId());
        }
    }

    @Override
    public Object findById(int id) throws DAOException {
        return executeObject(FIND_PUBLISHER_BY_ID, id);
    }

    @Override
    public List findAll() throws DAOException {
        return execute(FIND_ALL_PUBLISHER);
    }
}
