package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Author;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAuthorCommand implements ActionCommand {

    private static final String LAST_NAME_AUTHOR = "lastNameAuthor";
    private static final String FIRST_NAME_AUTHOR = "firstNameAuthor";
    private static final String SHOW_ADD_AUTHOR_OR_PUBLISHER = "admin";
    private static final String PAGE_JSP = "pageJSP";

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
        PageFactory pageFactory = new PageFactory();
        String page = pageFactory.createPage(SHOW_ADD_AUTHOR_OR_PUBLISHER);

        String lastName = request.getParameter(LAST_NAME_AUTHOR);
        String firstName = request.getParameter(FIRST_NAME_AUTHOR);

        Author author = new Author();
        author.setLastName(lastName);
        author.setFirstName(firstName);

        AuthorService authorService = new AuthorService();
        authorService.addAuthor(author);

        request.getSession().setAttribute(PAGE_JSP,page);

        response.sendRedirect(page);
    }
}
