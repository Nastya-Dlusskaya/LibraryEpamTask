package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.entity.Order;
import by.epam.library.model.entity.TypePlace;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;
import by.epam.library.util.CalenderCalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class HandOutCommand implements ActionCommand {

    private static final String TYPE = "type";
    private static final String ID = "id";
    private static final String PAGE_JSP = "pageJSP";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {

        String stringId = request.getParameter(ID);
        int idOrder = Integer.parseInt(stringId);

        OrderService orderService = new OrderService( );
        Order order = orderService.findOrderById(idOrder);

        Date dateNow = CalenderCalculator.calculateCurrentDate( );
        Timestamp now = new Timestamp(dateNow.getTime( ));
        order.setHandOutDate(now);

        String typeHandOut = request.getParameter(TYPE);
        TypePlace typePlace = TypePlace.getTypePlace(typeHandOut);
        order.setPlace(typePlace);

        Date datePlannedReturnDay = CalenderCalculator.calculatePlannedDate(typeHandOut);
        Timestamp plannedReturnDay = new Timestamp(datePlannedReturnDay.getTime( ));
        order.setPlannedReturnDate(plannedReturnDay);

        orderService.saveOrder(order);

        LibrarianCommand librarianCommand = new LibrarianCommand( );
        librarianCommand.execute(request, response);
    }
}
