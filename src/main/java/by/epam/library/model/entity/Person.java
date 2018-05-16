package by.epam.library.model.entity;

public class Person {
    public static final String ID_PERSON = "id_person";
    public static final String ROLE = "role";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String LAST_NAME_PERSON = "last_name_person";
    public static final String FIRST_NAME_PERSON = "first_name_person";
    public static final String IS_DELETED = "is_deleted";
    private static final String TABLE = "person";

    private Integer id;
    private TypePerson role;
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private Boolean isDeleted;

    public Person() {
    }

    public Person(int idPerson, TypePerson typePerson, String login, String password, String lastName, String firstName) {
        this.id = idPerson;
        this.role = typePerson;
        this.login = login;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isDeleted = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypePerson getRole() {
        return role;
    }

    public void setRole(TypePerson role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass( ) != object.getClass( )) {
            return false;
        }

        Person person = (Person) object;

        return (id == person.id) &&
                (role == person.role) &&
                (login == person.login || login != null && login.equals(person.login)) &&
                (password == person.password || password != null && password.equals(person.password)) &&
                (firstName == person.firstName || firstName != null && firstName.equals(person.firstName)) &&
                (lastName == person.lastName || lastName != null && lastName.equals(person.lastName));
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode( ) : 0);
        result = 31 * result + (login != null ? login.hashCode( ) : 0);
        result = 31 * result + (password != null ? password.hashCode( ) : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode( ) : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode( ) : 0);
        return result;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
