package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.MessageManager;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Book;
import by.epam.library.model.entity.Order;
import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;
import by.epam.library.services.OrderService;
import by.epam.library.util.CalenderCalculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
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
        int idBook = Integer.parseInt(stringIdBook);
        Book book = new Book();
        book.setId(idBook);

        Person person = (Person) request.getSession( ).getAttribute(USER);

        Date now = CalenderCalculator.calculateCurrentDate();

        Order order = new Order();
        order.setBook(book);
        order.setReader(person);

        Timestamp orderDate = new Timestamp(now.getTime());
        order.setOrderDate(orderDate);

        OrderService orderService = new OrderService( );
        orderService.orderBook(order);

        BookService bookService = new BookService();
        bookService.decrementAmountBook(idBook);

        String message = MessageManager.getProperty(MESSAGE_BOOK_ORDER);
        HttpSession session = request.getSession( );
        session.setAttribute(STRING, message);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
