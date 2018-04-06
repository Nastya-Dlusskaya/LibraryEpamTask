package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LibrarianCommand implements ActionCommand {

    private static final String LIBRARIAN = "librarian";
    private static final String ORDERS = "orders";
    public static final String CAPTION_BOOK = "captionBook";
    public static final String ORDERED_BOOK = "Ordered book";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(LIBRARIAN);

        OrderService orderService = new OrderService();

        List<Order> orders;
        try {
            orders = orderService.findOrders();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(CAPTION_BOOK, ORDERED_BOOK);
        currentSession.setAttribute(ORDERS, orders);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
