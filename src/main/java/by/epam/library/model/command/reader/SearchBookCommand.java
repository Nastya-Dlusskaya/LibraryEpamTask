package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.MessageManager;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchBookCommand implements ActionCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage("reader");

        String lastNameAuthor = request.getParameter("last_name");
        String nameBook = request.getParameter("name_book");

        List catalog = null;
        BookService bookService = new BookService( );
        if (lastNameAuthor.isEmpty( ) && nameBook.isEmpty( )) {
            catalog = bookService.findAllBook( );
        } else if (!lastNameAuthor.isEmpty( ) && !nameBook.isEmpty( )) {
            catalog = bookService.findBookByLastNameAuthorAndNameBook(lastNameAuthor, nameBook);
        } else if (!lastNameAuthor.isEmpty( )) {
            catalog = bookService.findBookByLastNameAuthor(lastNameAuthor);
        } else{
            catalog = bookService.findBookByNameBook(nameBook);
        }

        if (catalog == null) {
            String message = MessageManager.getProperty("message.response.empty");
            request.setAttribute("noDate", message);
        }

        request.getSession( ).setAttribute("books", catalog);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
