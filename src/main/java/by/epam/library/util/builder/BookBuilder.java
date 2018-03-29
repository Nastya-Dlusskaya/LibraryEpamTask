package by.epam.library.util.builder;

import by.epam.library.model.entity.Author;
import by.epam.library.model.entity.Book;
import by.epam.library.model.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBuilder implements Builder {

    private static final String ID = "id_book";
    private static final String NAME = "name_book";
    private static final String AMOUNT = "amount";

    @Override
    public Book buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);

        AuthorBuilder authorCreator = new AuthorBuilder();
        Author author = authorCreator.buildObject(resultSet);

        String name = resultSet.getString(NAME);

        PublisherBuilder publisherCreator = new PublisherBuilder();
        Publisher publisher = publisherCreator.buildObject(resultSet);

        int amount = resultSet.getInt(AMOUNT);
        return new Book(id, author, name, publisher, amount);
    }
}
