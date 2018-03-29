package by.epam.library.model.command;

import by.epam.library.model.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class LibrarianCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return null;
    }
}
