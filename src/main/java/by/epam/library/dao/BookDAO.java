package by.epam.library.dao;

import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.BookBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO extends AbstractDAO{

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
    //    public Catalog findBookByAuthor(String author){
//        String query = QUERY_FIND_TYPE_PERSON;
//        Person person;
//        PreparedStatement statement = null;
//        try {
//            statement = getConnection().prepareStatement(query);
//            statement.setString(1, author);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            person = (Person) getObject(resultSet);
//        } catch (SQLException e) {
//            throw new DAOException(e);
//        }
//        return person;
//    }
//
//    public Catalog findBookByName(String name){
//
//    }

}
