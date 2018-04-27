package by.epam.library.model.command.common;

import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements ActionCommand {

    private static final String EMPTY = "empty";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(EMPTY);
        HttpSession currnetSession = request.getSession();
        currnetSession.invalidate( );
        response.sendRedirect(page);
    }
}
