package by.epam.library.util.builder;

import by.epam.library.model.entity.Author;
import by.epam.library.model.entity.Book;
import by.epam.library.model.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBuilder implements Builder {

    @Override
    public Book buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Book.ID_BOOK);

        AuthorBuilder authorCreator = new AuthorBuilder();
        Author author = authorCreator.buildObject(resultSet);

        String name = resultSet.getString(Book.NAME_BOOK);

        PublisherBuilder publisherCreator = new PublisherBuilder();
        Publisher publisher = publisherCreator.buildObject(resultSet);

        int amount = resultSet.getInt(Book.AMOUNT);
        return new Book(id, author, name, publisher, amount);
    }
}
