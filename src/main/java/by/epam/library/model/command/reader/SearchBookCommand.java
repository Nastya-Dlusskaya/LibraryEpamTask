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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );

        Person person = (Person) request.getSession().getAttribute("user");
        TypePerson typePerson = person.getRole();

        String page;

        if(typePerson == TypePerson.READER){
            page = pageFactory.createPage("reader");
        } else{
            page = pageFactory.createPage("admin_table");
        }


        String lastNameAuthor = request.getParameter("last_name");
        String nameBook = request.getParameter("name_book");

        List catalog = null;
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
            String message = MessageManager.getProperty("message.response.empty");
            request.setAttribute("noDate", message);
        }

        request.setAttribute("entities", catalog);
        response.sendRedirect(page);
    }
}
