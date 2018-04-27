package by.epam.library.model.command.common;

import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class ChangeLanguageCommand implements ActionCommand {

    private static final String PAGE_JSP = "pageJSP";
    private static final String PATH_PAGE_LOGIN = "/jsp/login.jsp";
    private static final String LANGUAGE = "language";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        String page_JSP = (String)request.getSession().getAttribute(PAGE_JSP);
        String page = page_JSP != null ? page_JSP : PATH_PAGE_LOGIN;
        String language = request.getParameter(LANGUAGE);

        Config.set(request.getSession(),Config.FMT_LOCALE, language);
        request.getRequestDispatcher(page).forward(request, response);

    }
}
