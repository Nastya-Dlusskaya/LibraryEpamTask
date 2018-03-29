package by.epam.library.controller;

import by.epam.library.model.command.ActionCommand;
import by.epam.library.model.command.ActionFactory;
import by.epam.library.model.exception.CommandException;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String page = null;

        ActionFactory client = new by.epam.library.model.command.ActionFactory();
        String currentCommand = request.getParameter(COMMAND);
        ActionCommand command = client.defineCommand(currentCommand);

        try {
            page = command.execute(request);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        if(page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
