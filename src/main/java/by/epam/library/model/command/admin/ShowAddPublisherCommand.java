package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowAddPublisherCommand implements ActionCommand {

    private static final String ADD_AUTHOR_OR_PUBLISHER = "show_add_author_or_publisher";
    private static final String PUBLISHER = "publisher";
    private static final String TITLE = "title";
    private static final String ENTITIES = "entities";
    private static final String PAGE_JSP = "pageJSP";

    /**
     * Add list of publisher in page and loads it in response
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
        String page = pageFactory.createPage(ADD_AUTHOR_OR_PUBLISHER);

        PublisherService publisherService = new PublisherService();
        List publishers = publisherService.findAllPublisher( );

        HttpSession currentSession = request.getSession( );
        request.setAttribute(TITLE, PUBLISHER);
        request.setAttribute(ENTITIES, publishers);
        currentSession.setAttribute(PAGE_JSP,page);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
