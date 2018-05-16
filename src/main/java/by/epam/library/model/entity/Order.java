package by.epam.library.model.entity;

import java.sql.Timestamp;

public class Order {
    public static final String TABLE = "order";

    public static final String ID = "id";
    public static final String ID_PERSON = "id_person";
    public static final String ID_BOOK = "id_book";
    public static final String ORDER_DATE = "order_date";
    public static final String PLANNED_HAND_OUT_DATE = "planned_hand_out_date";
    public static final String HAND_OUT_DATE = "hang_out_date";
    public static final String PLANNED_RETURN_DATE = "planned_return_date";
    public static final String ACTUAL_RETURN_DATE = "actual_return_date";
    public static final String PLACE = "place";

    private Integer id;
    private Person reader;
    private Book book;
    private Timestamp orderDate;
    private Timestamp plannedHandOutDate;
    private Timestamp handOutDate;
    private Timestamp plannedReturnDate;
    private Timestamp actualReturnDate;
    private TypePlace place;

    public Order() {
    }

    public Order(Integer id, Person reader, Book book, Timestamp orderDate, Timestamp plannedHandOutDate,
                 Timestamp handOutDate, Timestamp plannedReturnDate, Timestamp actualReturnDate, TypePlace place) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.orderDate = orderDate;
        this.plannedHandOutDate = plannedHandOutDate;
        this.handOutDate = handOutDate;
        this.plannedReturnDate = plannedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getReader() {
        return reader;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getPlannedHandOutDate() {
        return plannedHandOutDate;
    }

    public void setPlannedHandOutDate(Timestamp plannedHandOutDate) {
        this.plannedHandOutDate = plannedHandOutDate;
    }

    public Timestamp getHandOutDate() {
        return handOutDate;
    }

    public void setHandOutDate(Timestamp handOutDate) {
        this.handOutDate = handOutDate;
    }

    public Timestamp getPlannedReturnDate() {
        return plannedReturnDate;
    }

    public void setPlannedReturnDate(Timestamp plannedReturnDate) {
        this.plannedReturnDate = plannedReturnDate;
    }

    public Timestamp getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Timestamp actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public TypePlace getPlace() {
        return place;
    }

    public void setPlace(TypePlace place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (reader != null ? !reader.equals(order.reader) : order.reader != null) return false;
        if (book != null ? !book.equals(order.book) : order.book != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (plannedHandOutDate != null ? !plannedHandOutDate.equals(order.plannedHandOutDate) : order.plannedHandOutDate != null)
            return false;
        if (handOutDate != null ? !handOutDate.equals(order.handOutDate) : order.handOutDate != null) return false;
        if (plannedReturnDate != null ? !plannedReturnDate.equals(order.plannedReturnDate) : order.plannedReturnDate != null)
            return false;
        if (actualReturnDate != null ? !actualReturnDate.equals(order.actualReturnDate) : order.actualReturnDate != null)
            return false;
        return place == order.place;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode( ) : 0;
        result = 31 * result + (reader != null ? reader.hashCode( ) : 0);
        result = 31 * result + (book != null ? book.hashCode( ) : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode( ) : 0);
        result = 31 * result + (plannedHandOutDate != null ? plannedHandOutDate.hashCode( ) : 0);
        result = 31 * result + (handOutDate != null ? handOutDate.hashCode( ) : 0);
        result = 31 * result + (plannedReturnDate != null ? plannedReturnDate.hashCode( ) : 0);
        result = 31 * result + (actualReturnDate != null ? actualReturnDate.hashCode( ) : 0);
        result = 31 * result + (place != null ? place.hashCode( ) : 0);
        return result;
    }
}
