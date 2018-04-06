package by.epam.library.dao;

import by.epam.library.model.entity.Author;
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
            "WHERE id_book=";

    private static final String FIND_ALL_BOOK = "SELECT * FROM library.book\n " +
            "JOIN author ON author.id_author=book.id_author\n " +
            "join publisher ON publisher.id_publisher=book.id_publisher";

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

    }

    @Override
    public Object findById(int id) throws DAOException {
        return (Author)executeObject(FIND_BOOK_BY_ID + id);
    }

    @Override
    public List findAll() throws DAOException {
        return execute(FIND_ALL_BOOK);
    }

    public List findBookByLastNameAuthorAndNameBook(String lastNameAuthor, String nameBook) {
        return null;
    }

    public List findBookByLastNameAuthor(String lastNameAuthor) {
        return null;
    }
}
