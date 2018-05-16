package by.epam.library.dao;

import by.epam.library.model.entity.Author;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.AuthorBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorDAO extends AbstractDAO {
    private static final String FIND_ALL_AUTHOR = "SELECT last_name_author, first_name_author, id_author " +
            "FROM library.author ORDER BY last_name_author";
    private static final String FIND_AUTHOR_BY_ID = "SELECT last_name_author, first_name_author, id_author " +
            "FROM library.author WHERE id_author=?";
    private static final String INSERT_QUERY = "INSERT INTO library.author(last_name_author, first_name_author)" +
            " VALUES(?, ?)";
    private static final String UPDATE_QUERY = "UPDATE library.author SET last_name_author=? first_name_author=? " +
            "WHERE id_author=?";

    public AuthorDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Author buildEntity(ResultSet resultSet) throws DAOException {
        AuthorBuilder authorBuilder = new AuthorBuilder( );
        try {
            return authorBuilder.buildObject(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage( ), e);
        }
    }


    @Override
    public void save(Object entity) throws DAOException {
        Author author = (Author) entity;
        Integer idAuthor = author.getId();
        if(idAuthor == null){
            change(INSERT_QUERY, author.getLastName(), author.getFirstName());
        } else{
            change(UPDATE_QUERY, author.getLastName(), author.getFirstName(), author.getId());
        }

    }

    @Override
    public Author findById(int id) throws DAOException {
        return (Author)executeObject(FIND_AUTHOR_BY_ID, id);
    }

    @Override
    public List findAll() throws DAOException {
        return execute(FIND_ALL_AUTHOR);
    }

}
