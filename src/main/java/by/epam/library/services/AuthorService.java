package by.epam.library.services;

import by.epam.library.dao.AuthorDAO;
import by.epam.library.dao.ConnectionPool;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class AuthorService {

    public List findAllAuthor() throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            AuthorDAO authorDAO = new AuthorDAO(connection);
            return authorDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public void addAuthor(String lastName, String firstName) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            AuthorDAO authorDAO = new AuthorDAO(connection);
            connectionPool.returnConnection(connection);
            //authorDAO.insert("author", "last_name_author", "first_name_author", lastName, firstName);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }
}
