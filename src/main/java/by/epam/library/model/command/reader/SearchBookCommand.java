package by.epam.library.model.command.reader;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.MessageManager;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Person;
import by.epam.library.model.entity.TypePerson;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchBookCommand implements ActionCommand {
    private static final String PAGE_JSP = "pageJSP";
    private static final String USER = "user";
    private static final String READER = "reader";
    private static final String ADMIN_TABLE = "admin_table";
    private static final String LAST_NAME = "last_name";
    private static final String NAME_BOOK = "name_book";
    private static final String MESSAGE_RESPONSE_EMPTY = "message.response.empty";
    private static final String NO_DATE = "noDate";
    private static final String ENTITIES = "entities";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );

        Person person = (Person) request.getSession().getAttribute(USER);
        TypePerson typePerson = person.getRole();

        String page;

        if(typePerson == TypePerson.READER){
            page = pageFactory.createPage(READER);
        } else{
            page = pageFactory.createPage(ADMIN_TABLE);
        }


        String lastNameAuthor = request.getParameter(LAST_NAME);
        String nameBook = request.getParameter(NAME_BOOK);

        List catalog;
        BookService bookService = new BookService( );
        if ((lastNameAuthor == null && nameBook == null) || (lastNameAuthor.isEmpty( ) && nameBook.isEmpty( ))) {
            catalog = bookService.findAllBook( );
        } else if (!lastNameAuthor.isEmpty( ) && !nameBook.isEmpty( )) {
            catalog = bookService.findBookByLastNameAuthorAndNameBook(lastNameAuthor, nameBook);
        } else if (!lastNameAuthor.isEmpty( )) {
            catalog = bookService.findBookByLastNameAuthor(lastNameAuthor);
        } else{
            catalog = bookService.findBookByNameBook(nameBook);
        }

        if (catalog == null) {
            String message = MessageManager.getProperty(MESSAGE_RESPONSE_EMPTY);
            request.setAttribute(NO_DATE, message);
        }

        request.setAttribute("typePage", "book");
        request.setAttribute(ENTITIES, catalog);
        request.getSession( ).setAttribute(PAGE_JSP, page);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
