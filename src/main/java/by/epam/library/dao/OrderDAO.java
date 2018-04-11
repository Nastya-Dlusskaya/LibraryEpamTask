package by.epam.library.dao;

import by.epam.library.model.entity.Author;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.OrderBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends AbstractDAO {
    private static final String QUERY_FIND_UNTREATED_ORDER = "SELECT * FROM library.order \n" +
            "join library.person on person.id_person=library.order.id_person\n " +
            "join library.book on library.order.id_book=book.id_book\n " +
            "JOIN library.author ON library.book.id_author = library.author.id_author\n" +
            "JOIN library.publisher ON library.book.id_publisher = library.publisher.id_publisher\n" +
            "where hang_out_date IS null";

    private static final String QUERY_FIND_READER_CURRENT_BOOK = "SELECT * FROM library.order \n" +
            "JOIN library.book ON library.order.id_book = library.book.id_book \n" +
            "JOIN library.publisher ON library.book.id_publisher = library.publisher.id_publisher \n" +
            "JOIN library.author ON library.book.id_author = library.author.id_author \n" +
            "JOIN library.person ON library.person.id_person = library.order.id_person \n" +
            "WHERE library.order.id_person = ? && library.order.actual_return_date IS NULL &&" +
            " library.order.planned_return_date IS NOT NULL;";

    private static final String QUERY_FIND_READER_ARCHIVE = "SELECT * FROM library.order \n" +
            "JOIN library.book ON library.order.id = library.book.id_book \n" +
            "JOIN library.publisher ON library.book.id_publisher = library.publisher.id_publisher \n" +
            "JOIN library.author ON library.book.id_author = library.author.id_author \n" +
            "JOIN library.person ON library.person.id_person = library.order.id_person \n" +
            "WHERE library.order.id_person = ? && library.order.actual_return_date IS NOT NULL";

    private static final String QUERY_FIND_READER_ORDERED_BOOK = "SELECT * FROM library.order \n" +
            "JOIN library.book ON library.order.id_book = library.book.id_book \n" +
            "JOIN library.publisher ON library.book.id_publisher = library.publisher.id_publisher \n" +
            "JOIN library.author ON library.book.id_author = library.author.id_author \n" +
            "JOIN library.person ON library.person.id_person = library.order.id_person \n" +
            "WHERE library.order.id_person = ? && " +
            " library.order.hang_out_date IS NULL";

    private static final String QUERY_FIND_HANDED_OUT_BOOK = "SELECT * FROM library.order\n " +
            "JOIN library.book ON library.order.id_book = library.book.id_book \n" +
            "JOIN library.publisher ON library.book.id_publisher = library.publisher.id_publisher \n" +
            "JOIN library.author ON library.book.id_author = library.author.id_author \n" +
            "JOIN library.person ON library.person.id_person = library.order.id_person\n " +
            "WHERE library.order.actual_return_date IS NULL && library.order.planned_return_date IS NOT NULL " +
            "ORDER BY library.order.planned_return_date DESC";

    private static final String INSERT_QUERY = "INSERT INTO library.order(id_person, id_book, order_date)" +
            " VALUES(?, ?, ?)";

    private static final String UPDATE_QUERY = "UPDATE library.order SET id_person=?, id_book=?, order_date=?, " +
            "planned_hand_out_date=?, hang_out_date=?, planned_return_date=?, actual_return_date=?, place=? " +
            "WHERE id=?";

    private static final String FIND_BY_ID = "SELECT * FROM library.order " +
            "JOIN library.book ON library.order.id_book = library.book.id_book \n" +
            "JOIN library.publisher ON library.book.id_publisher = library.publisher.id_publisher \n" +
            "JOIN library.author ON library.book.id_author = library.author.id_author \n" +
            "JOIN library.person ON library.person.id_person = library.order.id_person\n " +
            " WHERE id = ?";

    private static final String DELETE_QUERY = "DELETE FROM library.order WHERE id=?";

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order buildEntity(ResultSet resultSet) throws DAOException {
        OrderBuilder orderBuilder = new OrderBuilder();
        try {
            return orderBuilder.buildObject(resultSet);
        } catch (SQLException e) {
           throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Find untreated orders
     * @return
     * @throws DAOException
     */
    public List findAllUntreatedOrders() throws DAOException {
        return execute(QUERY_FIND_UNTREATED_ORDER);
    }

    public List findAllReturnOrders() throws DAOException {
        return execute(QUERY_FIND_HANDED_OUT_BOOK);
    }

    public List findUserCurrentBook(int id) throws DAOException {
        return execute(QUERY_FIND_READER_CURRENT_BOOK.replace("?", id + ""));
    }

    public List findUserArchive(int id) throws DAOException {
        return execute(QUERY_FIND_READER_ARCHIVE.replace("?", id + ""));
    }

    public List findUserOrderedBook(int id) throws DAOException {
        return execute(QUERY_FIND_READER_ORDERED_BOOK.replace("?", id + ""));
    }

    @Override
    public void save(Object entity) throws DAOException {
        Order order = (Order) entity;
        Integer id = order.getId();
        if(id == null){
            change(INSERT_QUERY, order.getReader().getId(), order.getBook().getId(), order.getOrderDate()) ;
        } else{
            change(UPDATE_QUERY, order.getReader().getId(), order.getBook().getId(), order.getOrderDate(),
                    order.getPlannedHandOutDate(), order.getHandOutDate(), order.getPlannedReturnDate(),
                    order.getActualReturnDate(), order.getPlace().name(), order.getId());
        }
    }

    @Override
    public Object findById(int id) throws DAOException {
        return executeObject(FIND_BY_ID, id);
    }

    @Override
    public List findAll() throws DAOException {
        return null;
    }

    public void deleteOrder(int idOrder) throws DAOException {
        change(DELETE_QUERY, idOrder);
    }
}
