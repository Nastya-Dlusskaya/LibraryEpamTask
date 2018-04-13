package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookCommand implements ActionCommand {

    /**
     * Adds book in database
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
        Book book = new Book();

        BookService bookService = new BookService();
        bookService.addBook(book);

        ShowAddOrEditBookCommand showAddOrEditBookCommand = new ShowAddOrEditBookCommand();
        showAddOrEditBookCommand.execute(request, response);
    }
}
