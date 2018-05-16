package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookCommand implements ActionCommand {

    private static final String ID_BOOK = "idBook";
    private static final String ADMIN_TABLE = "admin";
    private static final String PAGE_JSP = "pageJSP";

    /**
     * Deletes book from database
     *
     * @param request
     * @param response
     * @throws CommandException
     * @throws ServiceException
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory();
        String page = pageFactory.createPage(ADMIN_TABLE);

        String stringIdBook = request.getParameter(ID_BOOK);
        int idBook = Integer.parseInt(stringIdBook);

        BookService bookService = new BookService();
        Book book = bookService.findBookByID(idBook);

        book.setDeleted(true);

        request.getSession().setAttribute(PAGE_JSP,page);

        bookService.deletedBook(book);
        response.sendRedirect(page);
    }
}
