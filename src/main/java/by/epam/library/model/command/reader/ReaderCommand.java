package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReaderCommand implements ActionCommand {
    private static final String PAGE_JSP = "pageJSP";
    private static final String READER = "reader";
    private static final String BOOKS = "books";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(READER);

        BookService bookService = new BookService( );
        List books = bookService.findAllBook( );

        request.setAttribute(BOOKS, books);
        request.getSession().setAttribute(PAGE_JSP,page);

        response.sendRedirect(page);
    }
}
