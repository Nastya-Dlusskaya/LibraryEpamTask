package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowSearchPersonCommand implements ActionCommand {

    private static final String TYPE_PAGE = "admin_table";
    private static final String TYPE = "type";
    private static final String READER = "reader";
    private static final String READERS = "Readers";
    private static final String LIBRARIANS = "Librarians";
    private static final String TITLE = "title";
    private static final String CAPTION = "typePage";
    private static final String ENTITIES = "entities";
    private static final String PAGE_JSP = "pageJSP";


    /**
     * Inspie if type of person, load list of person in page and load it in response
     *
     * @param request
     * @param response
     * @throws CommandException
     * @throws ServiceException
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(TYPE_PAGE);
        String typePerson = request.getParameter(TYPE);

        PersonService personService = new PersonService( );

        List persons;
        String caption;

        if (typePerson.equals(READER)) {
            persons = personService.findAllReaders( );
            caption = READERS;
        } else {
            persons = personService.findAllLibrarian( );
            caption = LIBRARIANS;
        }

        HttpSession currentSession = request.getSession( );
        currentSession.setAttribute(TITLE, caption);
        currentSession.setAttribute(CAPTION, caption);
        currentSession.setAttribute(ENTITIES, persons);
        currentSession.setAttribute(PAGE_JSP, page);
        response.sendRedirect(page);
    }
}
