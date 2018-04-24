package by.epam.library.services;

import by.epam.library.dao.ConnectionPool;
import by.epam.library.dao.OrderDAO;
import by.epam.library.model.command.common.CommandEnum;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.IllegalTypeOfCommand;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class OrderService {

    public List<Order> findOrders(int page) throws ServiceException {
        ConnectionPool connectionPool = null;
        Connection connection = null;
        try {
            connectionPool = ConnectionPool.getInstance( );
            connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            List<Order> orders = orderDAO.findAllUntreatedOrders(page);
            return orders;
        } catch (DAOException exception) {
            throw new ServiceException(exception.getMessage( ), exception);
        } finally {
            if (connectionPool != null) {
                connectionPool.returnConnection(connection);
            }
        }

    }

    public List findReturnBook(int page) throws ServiceException {
        List<Order> orders;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            orders = orderDAO.findAllReturnOrders(page);
            connectionPool.returnConnection(connection);
        } catch (DAOException exception) {
            throw new ServiceException(exception.getMessage( ), exception);
        }
        return orders;
    }


    public void saveOrder(Order order) throws ServiceException {
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

    public List findUserCurrentBook(int id, int page) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return orderDAO.findUserCurrentBook(id, page);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public List findUserArchive(int id, int page) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return orderDAO.findUserArchive(id, page);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public List findUserOrderedBook(int id, int page) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return orderDAO.findUserOrderedBook(id, page);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public Order findOrderById(int id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            connectionPool.returnConnection(connection);
            return (Order) orderDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public void deleteOrder(int idOrder) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            orderDAO.deleteOrder(idOrder);
            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public int getCountPage(CommandEnum typeCommand, int... id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            OrderDAO orderDAO = new OrderDAO(connection);
            int maxPage = 0;
            if(id.length > 0){
                maxPage = orderDAO.getMaxPage(typeCommand, id[0]);
            } else {
                maxPage = orderDAO.getMaxPage(typeCommand);
            }

            connectionPool.returnConnection(connection);
            return (maxPage % 10) > 0 ? (maxPage / 10) + 1 : maxPage / 10;
        } catch (DAOException|IllegalTypeOfCommand e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }
}
