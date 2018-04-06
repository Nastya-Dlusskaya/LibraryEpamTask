package by.epam.library.services;

import by.epam.library.dao.ConnectionPool;
import by.epam.library.dao.PublisherDAO;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class PublisherService {
    public List findAllPublisher() throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            PublisherDAO publisherDAO = new PublisherDAO(connection);
            return publisherDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public void addPublisher(String namePublisher) throws ServiceException {
//        ConnectionPool connectionPool = null;
//        Connection connection = null;
//        try {
//            connectionPool = ConnectionPool.getInstance( );
//            connection = connectionPool.getConnection( );
//            PublisherDAO publisherDAO = new PublisherDAO(connection);
//            publisherDAO.insert("publisher", "name_publisher", namePublisher);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage( ), e);
//        } finally {
//            if (connectionPool != null) {
//                connectionPool.returnConnection(connection);
//            }
//        }
    }
}
