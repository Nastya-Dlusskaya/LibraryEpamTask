package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;
import by.epam.library.services.OrderService;
import by.epam.library.util.CalenderCalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class PostponeBookCommand implements ActionCommand {
    private static final String ID = "id";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        String stringId = request.getParameter(ID);
        int idOrder = Integer.parseInt(stringId);

        OrderService orderService = new OrderService();
        Order order = orderService.findOrderById(idOrder);

        Date datePlannedHandOutDate = CalenderCalculator.calculatePlannedDate("PUT_ASIDE_BOOK");
        Timestamp plannedHandOutDate = new Timestamp(datePlannedHandOutDate.getTime());
        order.setPlannedHandOutDate(plannedHandOutDate);

        orderService.saveOrder(order);

        LibrarianCommand librarianCommand = new LibrarianCommand( );
        librarianCommand.execute(request, response);
    }
}
