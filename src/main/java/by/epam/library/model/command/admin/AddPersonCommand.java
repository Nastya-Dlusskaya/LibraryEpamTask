package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePerson;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPersonCommand implements ActionCommand {
    private static final String PAGE_JSP = "pageJSP";
    private static final String ADMIN_TABLE = "admin_table";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String SELECTOR = "selector";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    /**
     * Adds person in database
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

        Person person = new Person();

        String lastName = request.getParameter(LAST_NAME);
        person.setLastName(lastName);

        String firstName = request.getParameter(FIRST_NAME);
        person.setFirstName(firstName);

        String stringTypePerson=request.getParameter(SELECTOR);
        TypePerson typePerson = TypePerson.getCommandEnum(stringTypePerson);
        person.setRole(typePerson);

        String login = request.getParameter(LOGIN);
        person.setLogin(login);

        String password = request.getParameter(PASSWORD);
        person.setPassword(password);

        PersonService personService = new PersonService();
        personService.savePerson(person);

        request.getSession().setAttribute(PAGE_JSP,page);

        response.sendRedirect(page);
    }
}
