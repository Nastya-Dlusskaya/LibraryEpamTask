package by.epam.library.model.entity;

public class Author {
    private int id;
    private String lastName;
    private String firstName;

    public Author() {
    }

    public Author(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass( ) != object.getClass( )) {
            return false;
        }

        Author author = (Author) object;


        return (id == author.id) &&
                (firstName == author.firstName || firstName != null && firstName.equals(author.firstName)) &&
                (lastName == author.lastName || lastName != null && lastName.equals(author.lastName));
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode( ) : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode( ) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'';
    }
}
