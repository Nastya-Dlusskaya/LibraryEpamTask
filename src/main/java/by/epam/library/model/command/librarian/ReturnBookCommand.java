package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.entity.Book;
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

public class ReturnBookCommand implements ActionCommand {
    private static final String ID = "id";
    private static final String PAGE_JSP = "pageJSP";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {

        String stringId = request.getParameter(ID);
        int id = Integer.parseInt(stringId);

        OrderService orderService = new OrderService( );
        Order order = orderService.findOrderById(id);

        Date dateNow = CalenderCalculator.calculateCurrentDate( );
        Timestamp now = new Timestamp(dateNow.getTime( ));
        order.setActualReturnDate(now);

        orderService.saveOrder(order);

        Book book = order.getBook( );
        int idBook = book.getId( );
        BookService bookService = new BookService( );
        bookService.incrementAmountBook(idBook);

        ShowPageReturnBookCommand pageReturnBookCommand = new ShowPageReturnBookCommand( );
        pageReturnBookCommand.execute(request, response);

    }
}
