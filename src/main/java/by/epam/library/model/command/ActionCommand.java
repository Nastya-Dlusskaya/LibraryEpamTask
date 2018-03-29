package by.epam.library.model.command;

import by.epam.library.model.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws CommandException;
}
