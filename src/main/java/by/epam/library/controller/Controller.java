package by.epam.library.controller;


import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.common.ActionFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    //private static final Logger log = LogManager.getLogger(Controller.class);
    private static final String COMMAND = "command";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * method of handling all requests
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionFactory client = ActionFactory.getInstance( );
        String currentCommand = request.getParameter(COMMAND);
        ActionCommand command = client.defineCommand(currentCommand);

        try {
            command.execute(request, response);
        } catch (CommandException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace( );
        }
    }
}
