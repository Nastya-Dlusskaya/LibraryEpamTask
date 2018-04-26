package by.epam.library.model.command.common;

import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class ChangeLanguageCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {

        String page = request.getAttribute("page") != null ? request.getParameter("page") : "/jsp/login.jsp";
        String language = request.getParameter("language");

        Config.set(request.getSession(),Config.FMT_LOCALE, language);
        request.getRequestDispatcher(page).forward(request, response);

    }
}
