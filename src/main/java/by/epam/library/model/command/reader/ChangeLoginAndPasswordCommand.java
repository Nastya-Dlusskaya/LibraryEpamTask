package by.epam.library.model.command.reader;

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

public class ChangeLoginAndPasswordCommand implements ActionCommand {

    private static final String READER = "reader";
    private static final String USER = "user";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PAGE_JSP = "pageJSP";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory();
        String page = pageFactory.createPage(READER);

        Person user = (Person)request.getSession().getAttribute(USER);
        String newUserLogin = request.getParameter(LOGIN);
        String newUserPassword = request.getParameter(PASSWORD);

        user.setLogin(newUserLogin);
        user.setPassword(newUserPassword);

        PersonService personService = new PersonService();
        personService.savePerson(user);

        request.getSession().setAttribute(PAGE_JSP,page);

        response.sendRedirect(page);
    }
}
