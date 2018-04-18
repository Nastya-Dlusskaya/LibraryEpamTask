package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePersonCommand implements ActionCommand {

    private static final String ID_PERSON = "idPerson";

    /**
     * Deletes person from database
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
        String page = pageFactory.createPage("admin_table");

        String stringIdPerson = request.getParameter(ID_PERSON);
        int idPerson = Integer.parseInt(stringIdPerson);

        PersonService personService = new PersonService();
        Person person = personService.findPersonByID(idPerson);

        person.setDeleted(true);

        personService.savePerson(person);

        response.sendRedirect(page);
    }
}
