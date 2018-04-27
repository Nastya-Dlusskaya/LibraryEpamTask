package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelOrderCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        String stringId = request.getParameter(ID);
        int idOrder = Integer.parseInt(stringId);

        OrderService orderService = new OrderService();
        orderService.deleteOrder(idOrder);

        LibrarianCommand librarianCommand = new LibrarianCommand( );
        librarianCommand.execute(request, response);
    }
}
