package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.common.CommandEnum;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ArchiveBookCommand implements ActionCommand {

    private static final String READER_LIST = "reader_list";
    private static final String USER = "user";
    private static final String ARCHIVE = "Archive";
    private static final String CAPTION_BOOK = "captionBook";
    private static final String ORDERS = "orders";
    private static final String CURRENT_PAGE = "currentPage";
    private static final String MAX_PAGE = "maxPage";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(READER_LIST);

        HttpSession currentSession = request.getSession( );
        Person person = (Person) currentSession.getAttribute(USER);
        int id = person.getId( );

        String stringPage = request.getParameter("page");
        int pageIndex = Integer.parseInt(stringPage);

        OrderService orderService = new OrderService( );
        List orders = orderService.findUserArchive(id, pageIndex);

        currentSession.setAttribute(CAPTION_BOOK, ARCHIVE);
        currentSession.setAttribute(ORDERS, orders);

        int maxPage = orderService.getCountPage(CommandEnum.ARCHIVE_BOOK, id);
        currentSession.setAttribute(CURRENT_PAGE, pageIndex);
        currentSession.setAttribute(MAX_PAGE, maxPage);

        response.sendRedirect(page);
    }
}
