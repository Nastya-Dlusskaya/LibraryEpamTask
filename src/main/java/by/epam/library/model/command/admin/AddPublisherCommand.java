package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.entity.Publisher;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPublisherCommand implements ActionCommand {

    public static final String NAME_PUBLISHER = "namePublisher";

    /**
     * Adds publisher in database
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
        String namePublisher = request.getParameter(NAME_PUBLISHER);

        Publisher publisher = new Publisher();
        publisher.setName(namePublisher);

        PublisherService publisherService = new PublisherService();
        publisherService.addPublisher(publisher);

        ShowAddPublisherCommand showAddPublisherCommand = new ShowAddPublisherCommand( );
        showAddPublisherCommand.execute(request, response);
    }
}
