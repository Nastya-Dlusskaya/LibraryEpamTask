package by.epam.library.util.builder;

import by.epam.library.model.entity.TypePerson;
import by.epam.library.model.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder {

    private static final String ID_PERSON = "id_person";
    private static final String ROLE = "role";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String LAST_NAME = "last_name_person";
    private static final String NAME_PERSON = "first_name_person";

    @Override
    public Person buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID_PERSON);

        String stringRole = resultSet.getString(ROLE);
        TypePerson typePerson = TypePerson.getCommandEnum(stringRole);

        String login = resultSet.getString(LOGIN);
        String password = resultSet.getString(PASSWORD);

        String lastName = resultSet.getString(LAST_NAME);
        String firstName = resultSet.getString(NAME_PERSON);
        return new Person(id, typePerson, login, password, lastName, firstName);
    }
}
