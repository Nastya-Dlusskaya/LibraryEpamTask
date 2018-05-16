package by.epam.library.services;

import by.epam.library.dao.BookDAO;
import by.epam.library.dao.ConnectionPool;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class BookService {

    public Book findBookByID(int id) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            return (Book) bookDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public List findAllBook() throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            return bookDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public void decrementAmountBook(int id) {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            Book book = (Book) bookDAO.findById(id);

            int amountBook = book.getAmount( );
            int newAmountBook = amountBook - 1;
            book.setAmount(newAmountBook);

            bookDAO.save(book);

            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace( );
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public void incrementAmountBook(int id) {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            Book book = (Book) bookDAO.findById(id);

            int amountBook = book.getAmount( );
            int newAmountBook = amountBook + 1;
            book.setAmount(newAmountBook);

            bookDAO.save(book);

            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace( );
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public List findBookByLastNameAuthorAndNameBook(String lastNameAuthor, String nameBook) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            return bookDAO.findBookByLastNameAuthorAndNameBook(lastNameAuthor, nameBook);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public List findBookByLastNameAuthor(String lastNameAuthor) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            return bookDAO.findBookByLastNameAuthor(lastNameAuthor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public List findBookByNameBook(String nameBook) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            return bookDAO.findBookByNameBook(nameBook);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }

    }

    public void addBook(Book book) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO authorDAO = new BookDAO(connection);
            authorDAO.save(book);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public void deletedBook(Book book) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            bookDAO.save(book);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }
}
