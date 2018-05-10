package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchPeopleCommand implements ActionCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
//        PageFactory pageFactory = new PageFactory( );
//
//        String lastNamePerson = request.getParameter("last_name");
//        String firstNamePerson = request.getParameter("first_name");
//
//        List<Person> catalog = null;
//        PersonService personService = new PersonService( );
//        if ((lastNamePerson == null && firstNamePerson == null) || (lastNamePerson.isEmpty( ) && firstNamePerson.isEmpty( ))) {
//            catalog = personService.findAllPersonByType( );
//        } else if (!lastNamePerson.isEmpty( ) && !firstNamePerson.isEmpty( )) {
//            catalog = personService.findPersonByLastNamePersonAndFirstNamePersonByType(lastNamePerson, firstNamePerson);
//        } else if (!lastNamePerson.isEmpty( )) {
//            catalog = personService.findBookByLastNamePersonByType(lastNamePerson);
//        } else{
//            catalog = personService.findBookByFirstNamePersonByType(firstNamePerson);
//        }
//
//        if (catalog == null) {
//            String message = MessageManager.getProperty(MESSAGE_RESPONSE_EMPTY);
//            request.setAttribute(NO_DATE, message);
//        }
//
//        request.getSession().setAttribute(ENTITIES, catalog);
//        request.getSession().setAttribute(PAGE_JSP,page);
//        response.sendRedirect(page);
    }
}
