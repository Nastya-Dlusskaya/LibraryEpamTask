package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.common.CommandEnum;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Order;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LibrarianCommand implements ActionCommand {

    private static final String LIBRARIAN = "librarian";
    private static final String ORDERS = "orders";
    private static final String CAPTION_BOOK = "typeTable";
    private static final String ORDERED_BOOK = "Ordered book";
    private static final String CURRENT_PAGE = "currentPage";
    private static final String MAX_PAGE = "maxPage";
    private static final String PAGE_JSP = "pageJSP";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(LIBRARIAN);

        int pageIndex;
        if(request.getParameter("page") == null) {
            pageIndex = (int) request.getAttribute("page");
        } else{
            String stringPageIndex = request.getParameter("page");
            pageIndex = Integer.parseInt(stringPageIndex);
        }

        OrderService orderService = new OrderService();

        List<Order> orders;
        try {
            orders = orderService.findOrders(pageIndex);

        HttpSession currentSession = request.getSession();
            request.setAttribute(CAPTION_BOOK, ORDERED_BOOK);
            request.setAttribute(ORDERS, orders);

        int maxPage = orderService.getCountPage(CommandEnum.LIBRARIAN);
            request.setAttribute(CURRENT_PAGE, pageIndex);
            request.setAttribute(MAX_PAGE, maxPage);
        currentSession.setAttribute(PAGE_JSP, page);

            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServiceException|IOException e) {
            throw new CommandException(e);
        } catch (ServletException e) {
            e.printStackTrace( );
        }
    }
}

