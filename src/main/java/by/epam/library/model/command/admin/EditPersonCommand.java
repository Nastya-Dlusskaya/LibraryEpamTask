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

public class EditPersonCommand implements ActionCommand {

    private static final String SHOW_ADD_OR_EDIT_PERSON = "admin";
    private static final String PAGE_JSP = "pageJSP";
    private static final String PERSON = "person";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String SELECTOR = "selector";


    /**
     * Edits person in database
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
        String page = pageFactory.createPage(SHOW_ADD_OR_EDIT_PERSON);
        Person person = (Person)request.getSession().getAttribute(PERSON);

        String lastName = request.getParameter(LAST_NAME);
        person.setLastName(lastName);

        String firstName = request.getParameter(FIRST_NAME);
        person.setFirstName(firstName);

        String stringTypePerson=request.getParameter(SELECTOR);
        TypePerson typePerson = TypePerson.getCommandEnum(stringTypePerson);
        person.setRole(typePerson);

        PersonService personService = new PersonService();
        personService.savePerson(person);

        request.getSession().setAttribute(PAGE_JSP,page);

        response.sendRedirect(page);
    }
}
