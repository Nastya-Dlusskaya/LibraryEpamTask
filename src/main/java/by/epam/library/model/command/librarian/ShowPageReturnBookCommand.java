package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowPageReturnBookCommand implements ActionCommand {

    public static final String CAPTION_BOOK = "captionBook";
    public static final String RETURNED_BOOK = "Returned book";
    public static final String ORDERS = "orders";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage("librarian");

        OrderService orderService = new OrderService( );
        List orders = orderService.findReturnBook( );

        request.getSession( ).setAttribute(CAPTION_BOOK, RETURNED_BOOK);
        request.getSession( ).setAttribute(ORDERS, orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
