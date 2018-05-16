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
            " first_name_person FROM person WHERE login=? AND password=md5(?) AND is_deleted=0";
    private static final String FIND_ALL_READER_QUERY = "SELECT * FROM person WHERE role='reader' AND is_deleted=0 " +
            "ORDER BY last_name_person";
    private static final String FIND_ALL_LIBRARIAN_QUERY = "SELECT * FROM person WHERE role='librarian' AND " +
            "is_deleted=0 ORDER BY last_name_person";
    private static final String INSERT_QUERY = "INSERT INTO library.person(role, login, password, last_name_person, " +
            "first_name_person, is_deleted) VALUES(?, ?, md5(?), ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE library.person SET role=?, login=?, password=md5(?), " +
            "last_name_person=?, f irst_name_person=?, is_deleted=? WHERE id_person=?";
    private static final String FIND_PERSON_BY_ID = "SELECT * FROM library.person WHERE id_person=? AND is_deleted=0";
    private static final String FIND_PERSON_BY_TYPE_AND_LAST_NAME = "SELECT * FROM library.person WHERE is_deleted=0" +
            " AND role=? AND last_name_person=?";
    private static final String FIND_PERSON_BY_TYPE_AND_FIRST_NAME = "SELECT * FROM library.person WHERE is_deleted=0" +
            " AND first_name_person=?";
    private static final String FIND_PERSON_BY_TYPE_AND_LAST_NAME_AND_FIRST_NAME = "SELECT * FROM library.person WHERE " +
            "is_deleted=0 AND last_name_person=? AND first_name_person=?";


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


    public List findPersonByLastNamePersonAndFirstNamePersonByType(String type, String lastName, String firstName)
            throws DAOException {
        return execute(FIND_PERSON_BY_TYPE_AND_LAST_NAME_AND_FIRST_NAME, type, lastName, firstName);
    }

    public List findBookByLastNamePersonByType(String type, String lastName) throws DAOException {
        return execute(FIND_PERSON_BY_TYPE_AND_LAST_NAME, type, lastName);
    }

    public List findBookByFirstNamePersonByType(String type, String firstName) throws DAOException {
        return execute(FIND_PERSON_BY_TYPE_AND_FIRST_NAME, type, firstName);
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

    public Person findPersonByLoginAndPassword(String login, String password) throws DAOException {
        return (Person) executeObject(QUERY_FIND_TYPE_PERSON, login, password);
    }
}
