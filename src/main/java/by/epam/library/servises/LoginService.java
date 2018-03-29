package by.epam.library.servises;

import by.epam.library.dao.PersonDAO;
import by.epam.library.dao.PoolConnection;
import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePerson;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;

public class LoginService {
    public TypePerson validateUser(String login, String password) throws ServiceException {
        TypePerson typePerson;
        try{
            PoolConnection poolConnection = PoolConnection.getInstance();
            Connection connection = poolConnection.getConnection();
            PersonDAO personDAO = new PersonDAO(connection);
            Person person = personDAO.findPersonByLoginAndPassword(login, password);
            if(person != null) {
                typePerson = person.getRole();
            } else {
                typePerson = TypePerson.UNKNOWN;
            }
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return typePerson;
    }
}
