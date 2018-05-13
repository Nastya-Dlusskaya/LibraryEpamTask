package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.AuthorService;
import by.epam.library.services.BookService;
import by.epam.library.services.PublisherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowAddOrEditBookCommand implements ActionCommand {

    private static final String SHOW_ADD_OR_EDIT_PERSON = "show_add_or_edit_book";
    private static final String ID_BOOK = "idBook";
    private static final String BOOK = "book";
    private static final String AUTHORS = "authors";
    private static final String PUBLISHERS = "publishers";
    private static final String PAGE_JSP = "pageJSP";

    /**
     * Inspire of type of action, load page in response. If action is create, fields in page will empty, else fields
     * in page will be have data of selected object
     *
     * @param request
     * @param response
     * @throws CommandException
     * @throws ServiceException
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException,
            ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(SHOW_ADD_OR_EDIT_PERSON);

        AuthorService authorService = new AuthorService();
        List authors = authorService.findAllAuthor();

        PublisherService publisherService = new PublisherService();
        List publishers = publisherService.findAllPublisher();

        String stringId = request.getParameter(ID_BOOK);
        HttpSession session = request.getSession();

        if(stringId != null){
            Integer id = Integer.parseInt(stringId);
            BookService bookService = new BookService();
            Book book = bookService.findBookByID(id);
            request.setAttribute(BOOK, book);
        }

        request.setAttribute(AUTHORS, authors);
        request.setAttribute(PUBLISHERS, publishers);
        session.setAttribute(PAGE_JSP,page);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
