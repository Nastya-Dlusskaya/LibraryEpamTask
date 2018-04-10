package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReaderCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage("reader");

        BookService bookService = new BookService( );
        List books = bookService.findAllBook( );

        request.setAttribute("books", books);
        response.sendRedirect(page);
    }
}
