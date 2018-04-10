package by.epam.library.services;

import by.epam.library.dao.ConnectionPool;
import by.epam.library.dao.OrderDAO;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class OrderService {

    private static final String ORDER_TABLE = "library.order";
    private static final String PLACE_FIELD = "place";
    private static final String HANG_OUT_DATE_FIELD = "hang_out_date";
    private static final String PLANNED_RETURN_DATE_FIELD = "planned_return_date";
    private static final String ORDER_ID = "id";
    private static final String BOOK_ID = "id_book";
    private static final String ACTUAL_RETURN_DATE = "actual_return_date";
    private static final String ID_PERSON = "id_person";
    private static final String ORDER_DATE = "order_date";

    public List<Order> findOrders() throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            List<Order> orders = orderDAO.findAllUntreatedOrders( );
            return orders;
        } catch (DAOException exception) {
            throw new ServiceException(exception.getMessage( ), exception);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }

    }

    public List findReturnBook() throws ServiceException {
        List<Order> orders;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            orders = orderDAO.findAllReturnOrders( );
            connectionPool.returnConnection(connection);
        } catch (DAOException exception) {
            throw new ServiceException(exception.getMessage( ), exception);
        }
        return orders;
    }



    public void orderBook(Order order) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            orderDAO.save(order);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }
    }

    public List findUserCurrentBook(int id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return orderDAO.findUserCurrentBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public List findUserArchive(int id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return orderDAO.findUserArchive(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public List findUserOrderedBook(int id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return orderDAO.findUserOrderedBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

}
