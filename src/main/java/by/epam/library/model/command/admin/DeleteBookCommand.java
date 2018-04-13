package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;
import by.epam.library.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookCommand implements ActionCommand {

    private static final String ID_BOOK = "idBook";

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
        String stringIdBook = request.getParameter(ID_BOOK);
        int idBook = Integer.parseInt(stringIdBook);

        BookService bookService = new BookService();
        Book book = bookService.findBookByID(idBook);

        book.setDeleted(true);

        bookService.deletedBook(book);

        ShowSearchPersonCommand showSearchPersonCommand = new ShowSearchPersonCommand();
        showSearchPersonCommand.execute(request, response);
    }
}
