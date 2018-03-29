package by.epam.library.model.command;

import by.epam.library.model.command.commandUtil.MessageManager;
import by.epam.library.model.command.commandUtil.PageFactory;
import by.epam.library.model.entity.TypePerson;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.servises.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    /**
     * Send request and get type of user
     * @param request
     * @return
     * @throws CommandException
     */
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;

        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);

        LoginService loginService = new LoginService();

        TypePerson typePerson = null;
        try {
            typePerson = loginService.validateUser(login, password );
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        PageFactory factory = new PageFactory();
        page = factory.createPage(typePerson);

        if (typePerson != TypePerson.UNKNOWN){
            request.setAttribute("user",login);
        } else {
            String message = MessageManager.getProperty("message.login.error");
            request.setAttribute("wrongAction", message);
        }

        return page;
    }
}
