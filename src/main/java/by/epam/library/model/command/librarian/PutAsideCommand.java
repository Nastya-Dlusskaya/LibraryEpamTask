package by.epam.library.model.command.librarian;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PutAsideCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory();
        String page = pageFactory.createPage("librarian");


    }
}
