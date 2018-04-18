package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PersonService;
import by.epam.library.util.LoginAndPasswordGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowAddOrEditPersonCommand implements ActionCommand {

    private static final String SHOW_ADD_OR_EDIT_PERSON = "show_add_or_edit_person";

    /**
     * Inspire of type of action, load page in response. If action is create, fields in page will empty, else fields
     * in page will be have data of selected object
     *
     * @param request
     * @param response
     * @throws CommandException
     * @throws ServiceException
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(SHOW_ADD_OR_EDIT_PERSON);

        HttpSession session = request.getSession();
        String stringID = request.getParameter("idPerson");
        if(stringID != null){
            int id = Integer.parseInt(stringID);

            PersonService personService = new PersonService();
            Person person = personService.findPersonByID(id);

            session.setAttribute("person",person);
        } else{
            String generatedLogin = LoginAndPasswordGenerator.createRandomString(6, 10);
            session.setAttribute("login", generatedLogin);
            String generatedPassword = LoginAndPasswordGenerator.createRandomString(6, 10);
            session.setAttribute("password", generatedPassword);
        }
        response.sendRedirect(page);

    }
}
