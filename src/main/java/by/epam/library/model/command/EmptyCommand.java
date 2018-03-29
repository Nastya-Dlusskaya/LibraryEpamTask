package by.epam.library.model.command;

import by.epam.library.model.command.commandUtil.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    public static final String PATH_PAGE_LOGIN = "path.page.login";

    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty(PATH_PAGE_LOGIN);
    }
}
