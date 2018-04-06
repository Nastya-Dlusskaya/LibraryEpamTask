package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAuthorCommand implements ActionCommand {

    public static final String LAST_NAME_AUTHOR = "lastNameAuthor";
    public static final String FIRST_NAME_AUTHOR = "firstNameAuthor";

    /**
     * Adds author in database
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
        String lastName = request.getParameter(LAST_NAME_AUTHOR);

        String firstName = request.getParameter(FIRST_NAME_AUTHOR);

        AuthorService authorService = new AuthorService();
        authorService.addAuthor(lastName, firstName);

        ShowAddAuthorCommand pageReturnBookCommand = new ShowAddAuthorCommand( );
        pageReturnBookCommand.execute(request, response);
    }
}
