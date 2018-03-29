package by.epam.library.model.entity;

public class Book {
    private int id;
    private Author author;
    private String name;
    private Publisher publisher;
    private int amount;

    public Book() {
    }

    public Book(int id, Author author, String name, Publisher publisher, int amount) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.publisher = publisher;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass( ) != object.getClass( )) {
            return false;
        }

        Book book = (Book) object;

        return (id == book.id) &&
                (amount == book.amount) &&
                (author == book.author || author != null && author.equals(book.author)) &&
                (name == book.name || name != null && name.equals(book.name)) &&
                (publisher == book.publisher || publisher != null && publisher.equals(book.publisher));
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (author != null ? author.hashCode( ) : 0);
        result = 31 * result + (name != null ? name.hashCode( ) : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode( ) : 0);
        result = 31 * result + amount;
        return result;
    }
}
