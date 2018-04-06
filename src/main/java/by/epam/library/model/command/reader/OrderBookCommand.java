package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.MessageManager;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;
import by.epam.library.util.CalenderCalculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class OrderBookCommand implements ActionCommand {

    private static final String ID_BOOK = "idBook";
    private static final String USER = "user";
    private static final String MESSAGE_BOOK_ORDER = "message.book.order";
    private static final String STRING = "bookOrder";
    private static final String READER = "reader";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(READER);
        String stringIdBook = request.getParameter(ID_BOOK);
        int ibBook = Integer.parseInt(stringIdBook);

        Person person = (Person) request.getSession( ).getAttribute(USER);
        int idPerson = person.getId( );

        OrderService orderService = new OrderService( );
        Date now = CalenderCalculator.calculateCurrentDate();
        //orderService.orderBook(ibBook, idPerson, now);

        String message = MessageManager.getProperty(MESSAGE_BOOK_ORDER);
        HttpSession session = request.getSession( );
        session.setAttribute(STRING, message);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
