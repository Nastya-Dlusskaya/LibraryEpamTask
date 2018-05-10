package by.epam.library.dao;

import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.BookBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDAO extends AbstractDAO {

    private static final String FIND_BOOK_BY_ID = "SELECT * FROM library.book\n " +
            "JOIN author ON author.id_author=book.id_author\n " +
            "join publisher ON publisher.id_publisher=book.id_publisher\n " +
            "WHERE id_book=? AND is_deleted=0";

    private static final String FIND_ALL_BOOK = "SELECT * FROM library.book\n " +
            "JOIN author ON author.id_author=book.id_author\n " +
            "join publisher ON publisher.id_publisher=book.id_publisher " +
            "WHERE is_deleted=0";

    private static final String FIND_BOOK_BY_LAST_NAME = "SELECT * FROM library.book \n" +
            "JOIN author ON author.id_author = book.id_author\n" +
            "JOIN publisher ON publisher.id_publisher = book.id_publisher\n" +
            "WHERE author.last_name_author = ? AND is_deleted=0";

    private static final String FIND_BOOK_BY_NAME_BOOK = "SELECT * FROM library.book \n" +
            "JOIN author ON author.id_author = book.id_author\n" +
            "JOIN publisher ON publisher.id_publisher = book.id_publisher\n" +
            "WHERE book.name_book = ? AND is_deleted=0";

    private static final String FIND_BOOK_BY_NAME_BOOK_AND_LAST_NAME = "SELECT * FROM library.book \n" +
            "JOIN author ON author.id_author = book.id_author\n" +
            "JOIN publisher ON publisher.id_publisher = book.id_publisher\n" +
            "WHERE book.name_book = ? AND author.last_name_author = ? AND is_deleted=0";

    private static final String INSERT_QUERY = "INSERT INTO library.book(id_author, name_book, id_publisher, amount, is_deleted)" +
            " VALUES(?, ?, ?, ?, ?)";

    private static final String UPDATE_QUERY = "UPDATE library.book SET id_author=?, name_book=?, id_publisher=?, " +
            "amount=?, is_deleted=? WHERE id_book=?";

    public BookDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Book buildEntity(ResultSet resultSet) throws DAOException {
        try {
            BookBuilder bookBuilder = new BookBuilder();
            return bookBuilder.buildObject(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }

    }

    @Override
    public void save(Object entity) throws DAOException {
        Book book = (Book) entity;
        Integer id = book.getId();
        if(id == null){
            change(INSERT_QUERY, book.getAuthor().getId(), book.getName(), book.getPublisher().getId(),
                    book.getAmount(), book.getDeleted()) ;
        } else{
            change(UPDATE_QUERY, book.getAuthor().getId(), book.getName(), book.getPublisher().getId(),
                    book.getAmount(), book.getDeleted(), book.getId());
        }
    }

    @Override
    public Object findById(int id) throws DAOException {
        return executeObject(FIND_BOOK_BY_ID, id);
    }

    @Override
    public List findAll() throws DAOException {
        return execute(FIND_ALL_BOOK);
    }

    public List findBookByLastNameAuthorAndNameBook(String lastNameAuthor, String nameBook) throws DAOException {
        return execute(FIND_BOOK_BY_NAME_BOOK_AND_LAST_NAME, nameBook, lastNameAuthor);
    }

    public List findBookByLastNameAuthor(String lastNameAuthor) throws DAOException {
        return execute(FIND_BOOK_BY_LAST_NAME, lastNameAuthor);
    }

    public List findBookByNameBook(String nameBook) throws DAOException {
        return execute(FIND_BOOK_BY_NAME_BOOK, nameBook);
    }
}
