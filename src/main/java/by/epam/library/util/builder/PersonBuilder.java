package by.epam.library.util.builder;

import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePerson;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder {

    @Override
    public Person buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Person.ID_PERSON);

        String stringRole = resultSet.getString(Person.ROLE);
        TypePerson typePerson = TypePerson.getCommandEnum(stringRole);

        String login = resultSet.getString(Person.LOGIN);
        String password = resultSet.getString(Person.PASSWORD);

        String lastName = resultSet.getString(Person.LAST_NAME_PERSON);
        String firstName = resultSet.getString(Person.FIRST_NAME_PERSON);
        return new Person(id, typePerson, login, password, lastName, firstName);
    }
}
