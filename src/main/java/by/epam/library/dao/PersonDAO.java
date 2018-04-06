package by.epam.library.dao;

import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.PersonBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO extends AbstractDAO {

    private static final String QUERY_FIND_TYPE_PERSON = "SELECT id_person, role, login, password, last_name_person," +
            " first_name_person FROM person WHERE login=? AND password=?";

    private static final String FIND_ALL_READER_QUERY = "SELECT * FROM person WHERE role='reader'";

    private static final String FIND_ALL_LIBRARIAN_QUERY = "SELECT * FROM person WHERE role='librarian'";

    public PersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Object buildEntity(ResultSet resultSet) throws DAOException {
        try {
            PersonBuilder personBuilder = new PersonBuilder();
            return personBuilder.buildObject(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Find type of person
     * @param login
     * @param password
     * @return
     * @throws DAOException
     */
    public Person findPersonByLoginAndPassword(String login, String password) throws DAOException {
        String query = QUERY_FIND_TYPE_PERSON;
        Person person = null;
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                PersonBuilder personCreator = new PersonBuilder();
                person = personCreator.buildObject(resultSet);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return person;
    }


    public List findAllReader() throws DAOException {
        return execute(FIND_ALL_READER_QUERY);
    }

    public Person findPersonByID(int id) {
        return null;
    }

    public List findAllLibrarian() throws DAOException {
        return execute(FIND_ALL_LIBRARIAN_QUERY);
    }

    @Override
    public void save(Object entity) throws DAOException {

    }

    @Override
    public Object findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List findAll() throws DAOException {
        return null;
    }
}
