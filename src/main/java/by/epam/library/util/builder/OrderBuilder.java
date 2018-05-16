package by.epam.library.util.builder;

import by.epam.library.model.entity.Book;
import by.epam.library.model.entity.Order;
import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePlace;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderBuilder implements Builder {

    @Override
    public Order buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Order.ID);

        PersonBuilder personCreator = new PersonBuilder();
        Person person = personCreator.buildObject(resultSet);

        BookBuilder bookCreator = new BookBuilder();
        Book book = bookCreator.buildObject(resultSet);

        Timestamp orderDate = resultSet.getTimestamp(Order.ORDER_DATE);
        Timestamp plannedHandOutDate = resultSet.getTimestamp(Order.PLANNED_HAND_OUT_DATE);
        Timestamp hangOutDate = resultSet.getTimestamp(Order.HAND_OUT_DATE);
        Timestamp plannedReturnDate = resultSet.getTimestamp(Order.PLANNED_RETURN_DATE);
        Timestamp actualReturnDate = resultSet.getTimestamp(Order.ACTUAL_RETURN_DATE);

        String place = resultSet.getString(Order.PLACE);
        TypePlace typePlace = TypePlace.getTypePlace(place);
        return new Order(id, person, book, orderDate, plannedHandOutDate, hangOutDate, plannedReturnDate,
                actualReturnDate, typePlace);
    }
}
