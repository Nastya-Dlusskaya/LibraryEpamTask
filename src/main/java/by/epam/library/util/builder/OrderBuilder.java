package by.epam.library.util.builder;

import by.epam.library.model.entity.Order;
import by.epam.library.model.entity.TypePlace;
import by.epam.library.model.entity.Book;
import by.epam.library.model.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderBuilder implements Builder {

    private static final String ID = "id";
    private static final String ORDER_DATE = "order_date";
    private static final String HANG_OUT_DATE = "hang_out_date";
    private static final String PLANNED_RETURN_DATE = "planned_return_date";
    private static final String ACTUAL_RETURN_DATE = "actual_return_date";
    private static final String PLACE = "place";

    @Override
    public Order buildObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);

        PersonBuilder personCreator = new PersonBuilder();
        Person person = personCreator.buildObject(resultSet);

        BookBuilder bookCreator = new BookBuilder();
        Book book = bookCreator.buildObject(resultSet);

        Date orderDate = resultSet.getDate(ORDER_DATE);
        Date hangOutDate = resultSet.getDate(HANG_OUT_DATE);
        Date plannedReturnDate = resultSet.getDate(PLANNED_RETURN_DATE);
        Date actualReturnDate = resultSet.getDate(ACTUAL_RETURN_DATE);

        String place = resultSet.getString(PLACE);
        TypePlace typePlace = TypePlace.getTypePlace(place);
        return new Order();
    }
}
