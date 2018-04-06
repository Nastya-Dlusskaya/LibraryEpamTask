package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;
import by.epam.library.services.OrderService;
import by.epam.library.util.CalenderCalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HandOutCommand implements ActionCommand {

    private static final String TYPE = "type";
    private static final String ID = "id";
    private static final String ID_BOOK = "idBook";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage("librarian");

        String typeHandOut = request.getParameter(TYPE);

        String stringId = request.getParameter(ID);
        int id = Integer.parseInt(stringId);

        String stringIdBook = request.getParameter(ID_BOOK);
        int idBook = Integer.parseInt(stringIdBook);

        OrderService orderService = new OrderService();
        //orderService.setTypePlace(typeHandOut,id);

        Date now = CalenderCalculator.calculateCurrentDate();
        //orderService.setHandOutDate(id, now);

        Date plannedReturnDay = CalenderCalculator.calculatePlannedReturnDate(typeHandOut);
        //orderService.setPlannedReturnDate(plannedReturnDay, id);

        BookService bookService = new BookService();
        bookService.decrementAmountBook(idBook);

        LibrarianCommand librarianCommand = new LibrarianCommand( );
        librarianCommand.execute(request, response);
    }
}
