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
import java.util.List;

public class SearchPeopleCommand implements ActionCommand {
    private static final String PAGE_JSP = "pageJSP";
    private static final String CAPTION = "typePage";
    private static final String ENTITIES = "entities";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage("admin_table");

        String lastNamePerson = request.getParameter("last_name");
        String firstNamePerson = request.getParameter("first_name");
        String typePerson = request.getParameter("type");

        List<Person> catalog = null;
        PersonService personService = new PersonService( );
        if ((lastNamePerson == null && firstNamePerson == null) || (lastNamePerson.isEmpty( ) && firstNamePerson.isEmpty( ))) {
            catalog = personService.findAllPersonByType(typePerson);
        } else if (!lastNamePerson.isEmpty( ) && !firstNamePerson.isEmpty( )) {
            catalog = personService.findPersonByLastNamePersonAndFirstNamePersonByType(typePerson, lastNamePerson, firstNamePerson);
        } else if (!lastNamePerson.isEmpty( )) {
            catalog = personService.findBookByLastNamePersonByType(typePerson, lastNamePerson);
        } else {
            catalog = personService.findBookByFirstNamePersonByType(typePerson, firstNamePerson);
        }

        request.setAttribute(CAPTION, typePerson);
        request.setAttribute(ENTITIES, catalog);
        request.getSession( ).setAttribute(PAGE_JSP, page);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
