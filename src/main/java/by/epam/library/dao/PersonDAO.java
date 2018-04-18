package by.epam.library.dao;

import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.DAOException;
import by.epam.library.util.builder.PersonBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO extends AbstractDAO {

    private static final String QUERY_FIND_TYPE_PERSON = "SELECT id_person, role, login, password, last_name_person," +
            " first_name_person FROM person WHERE login=? AND password=? AND is_deleted=0";
    private static final String FIND_ALL_READER_QUERY = "SELECT * FROM person WHERE role='reader' AND is_deleted=0";
    private static final String FIND_ALL_LIBRARIAN_QUERY = "SELECT * FROM person WHERE role='librarian' AND is_deleted=0";
    private static final String INSERT_QUERY = "INSERT INTO library.person(role, login, password, last_name_person, " +
            "first_name_person, is_deleted) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE library.person SET role=?, login=?, password=?, " +
            "last_name_person=?, first_name_person=?, is_deleted=? WHERE id_person=?";
    private static final String FIND_PERSON_BY_ID = "SELECT * FROM library.person WHERE id_person=? AND is_deleted=0";

    public PersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Object buildEntity(ResultSet resultSet) throws DAOException {
        try {
            PersonBuilder personBuilder = new PersonBuilder( );
            return personBuilder.buildObject(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage( ), e);
        }
    }

    /**
     * Find type of person
     *
     * @param login
     * @param password
     * @return
     * @throws DAOException
     */
    public Person findPersonByLoginAndPassword(String login, String password) throws DAOException {
        return (Person) executeObject(QUERY_FIND_TYPE_PERSON, login, password);
    }


    public List findAllReader() throws DAOException {
        return execute(FIND_ALL_READER_QUERY);
    }

    public List findAllLibrarian() throws DAOException {
        return execute(FIND_ALL_LIBRARIAN_QUERY);
    }

    @Override
    public void save(Object entity) throws DAOException {
        Person person = (Person) entity;
        Integer personId = person.getId( );
        if (personId == null) {
            change(INSERT_QUERY, person.getRole( ).name(), person.getLogin( ), person.getPassword( ), person.getLastName( ),
                    person.getFirstName( ), person.getDeleted( ));
        } else {
            change(UPDATE_QUERY, person.getRole( ).name(), person.getLogin( ), person.getPassword( ), person.getLastName( ),
                    person.getFirstName( ), person.getDeleted( ), person.getId( ));
        }
    }

    @Override
    public Object findById(int id) throws DAOException {
        return executeObject(FIND_PERSON_BY_ID, id);
    }

    @Override
    public List findAll() throws DAOException {
        return null;
    }
}
