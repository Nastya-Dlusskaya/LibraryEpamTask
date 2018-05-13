package by.epam.library.model.command.common;

import by.epam.library.model.command.util.MessageManager;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePerson;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements ActionCommand {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";
    private static final String PAGE = "page";
    private static final int NUMBER_PAGE = 1;
    private static final String USER = "user";
    private static final String MESSAGE_LOGIN_ERROR = "message.login.error";
    private static final String WRONG_ACTION = "wrongAction";
    private static final String PAGE_JSP = "pageJSP";

    /**
     * Send request and get type of user
     *
     * @param request
     * @return
     * @throws CommandException
     */
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServletException, IOException, ServiceException {
        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);

        PersonService personService = new PersonService( );

        Person currentUser = personService.validateUser(login, password);

        TypePerson typePerson;
        if (currentUser == null) {
            typePerson = TypePerson.UNKNOWN;
        } else {
            typePerson = currentUser.getRole( );
        }

        PageFactory factory = new PageFactory( );
        String page = factory.createPage(typePerson.toString( ));

        HttpSession currentSession = request.getSession(true);

        if (typePerson != TypePerson.UNKNOWN) {
            currentSession.setAttribute(USER, currentUser);

            ActionFactory actionFactory = ActionFactory.getInstance( );
            String role = typePerson.toString( );
            ActionCommand command = actionFactory.defineCommand(role);
            request.setAttribute(PAGE, NUMBER_PAGE);
            command.execute(request, response);
        } else {
            String message = MessageManager.getProperty(MESSAGE_LOGIN_ERROR);
            currentSession.setAttribute(PAGE_JSP,page);
            currentSession.setAttribute(WRONG_ACTION, message);
            response.sendRedirect(page);
        }

    }
}
