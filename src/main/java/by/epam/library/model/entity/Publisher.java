package by.epam.library.model.entity;

public class Publisher {
    private Integer id;
    private String name;

    public Publisher() {
    }

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass( ) != object.getClass( )) {
            return false;
        }

        Publisher publisher = (Publisher) object;

        return (id == publisher.id) &&
                (name == publisher.name || name != null && name.equals(publisher.name));
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode( ) : 0);
        return result;
    }
}
