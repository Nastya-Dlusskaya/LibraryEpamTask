package by.epam.library.services;

import by.epam.library.dao.ConnectionPool;
import by.epam.library.dao.PersonDAO;
import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class PersonService {

    public List findAllLibrarian() throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            PersonDAO personDAO = new PersonDAO(connection);
            connectionPool.returnConnection(connection);
            return personDAO.findAllLibrarian( );
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public List findAllReaders() throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            PersonDAO personDAO = new PersonDAO(connection);
            connectionPool.returnConnection(connection);
            return personDAO.findAllReader( );
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public Person validateUser(String login, String password) throws ServiceException {
        Person person;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );

            PersonDAO personDAO = new PersonDAO(connection);
            person = personDAO.findPersonByLoginAndPassword(login, password);

            connectionPool.returnConnection(connection);

        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return person;
    }

    public Person findPersonByID(int id) throws ServiceException {
        Person person;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );

            PersonDAO personDAO = new PersonDAO(connection);
            person = (Person) personDAO.findById(id);

            connectionPool.returnConnection(connection);

        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return person;
    }


    public void savePerson(Person person) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );

            PersonDAO personDAO = new PersonDAO(connection);
            personDAO.save(person);

            connectionPool.returnConnection(connection);

        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
    }

}
