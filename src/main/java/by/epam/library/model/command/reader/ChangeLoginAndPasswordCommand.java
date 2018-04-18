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
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory();
        String page = pageFactory.createPage("reader");
        Person user = (Person)request.getSession().getAttribute("user");
        String newUserLogin = request.getParameter("login");
        String newUserPassword = request.getParameter("password");
        user.setLogin(newUserLogin);
        user.setPassword(newUserPassword);
        PersonService personService = new PersonService();
        personService.savePerson(user);
        response.sendRedirect(page);
    }
}
