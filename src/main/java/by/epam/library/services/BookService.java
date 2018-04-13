package by.epam.library.services;

import by.epam.library.dao.BookDAO;
import by.epam.library.dao.ConnectionPool;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class BookService {

    private static final String BOOK_TABLE = "library.book";
    private static final String AMOUNT_FIELD = "amount";
    private static final String BOOK_ID = "id_book";

    public Book findBookByID(int id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            return (Book) bookDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            //connectionPool.returnConnection(connection);
        }
    }

    public List findAllBook() throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            connectionPool.returnConnection(connection);
            return bookDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public void decrementAmountBook(int id) {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            Book book = (Book) bookDAO.findById(id);

            int amountBook = book.getAmount( );
            int newAmountBook = amountBook - 1;
            book.setAmount(newAmountBook);

            bookDAO.save(book);

            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace( );
        }
    }

    public void incrementAmountBook(int id) {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            Book book = (Book) bookDAO.findById(id);

            int amountBook = book.getAmount( );
            int newAmountBook = amountBook + 1;
            book.setAmount(newAmountBook);

            bookDAO.save(book);

            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace( );
        }
    }

    public List findBookByLastNameAuthorAndNameBook(String lastNameAuthor, String nameBook) throws ServiceException {
        List catalog;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            catalog = bookDAO.findBookByLastNameAuthorAndNameBook(lastNameAuthor, nameBook);
            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
        return catalog;
    }

    public List findBookByLastNameAuthor(String lastNameAuthor) throws ServiceException {
        List catalog;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            catalog = bookDAO.findBookByLastNameAuthor(lastNameAuthor);
            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
        return catalog;
    }

    public List findBookByNameBook(String nameBook) throws ServiceException {
        List catalog;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            catalog = bookDAO.findBookByNameBook(nameBook);
            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
        return catalog;
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
}
