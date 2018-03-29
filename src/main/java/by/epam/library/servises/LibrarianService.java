package by.epam.library.servises;

import by.epam.library.dao.OrderDAO;
import by.epam.library.dao.PoolConnection;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class LibrarianService {
    public List<Order> findOrders() throws ServiceException {
        List<Order> orders = new LinkedList<>();
        try{
            PoolConnection poolConnection = PoolConnection.getInstance();
            Connection connection = poolConnection.getConnection();
            OrderDAO orderDAO = new OrderDAO(connection);
            orders = orderDAO.findAllUntreatedOrders();
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return orders;
    }
}
