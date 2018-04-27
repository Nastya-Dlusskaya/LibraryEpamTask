package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.entity.Author;
import by.epam.library.model.entity.Book;
import by.epam.library.model.entity.Publisher;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookCommand implements ActionCommand {

    private static final String SHOW_ADD_OR_EDIT_BOOK = "show_add_or_edit_book";
    private static final String LIST_AUTHOR = "listAuthor";
    private static final String NAME_BOOK = "nameBook";
    private static final String LIST_PUBLISHERS = "listPublishers";
    private static final String AMOUNT = "amount";
    private static final String PAGE_JSP = "pageJSP";

    /**
     * Adds book in database
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
        PageFactory pageFactory = new PageFactory();
        String page = pageFactory.createPage(SHOW_ADD_OR_EDIT_BOOK);

        Book book = new Book();

        String stringIdAuthor = request.getParameter(LIST_AUTHOR);
        int idAuthor = Integer.parseInt(stringIdAuthor);
        Author author = new Author();
        author.setId(idAuthor);
        book.setAuthor(author);

        String name = request.getParameter(NAME_BOOK);
        book.setName(name);

        String stringIdPublisher = request.getParameter(LIST_PUBLISHERS);
        int idPublisher = Integer.parseInt(stringIdPublisher);
        Publisher publisher = new Publisher();
        publisher.setId(idPublisher);
        book.setPublisher(publisher);

        String stringAmount = request.getParameter(AMOUNT);
        int amount = Integer.parseInt(stringAmount);
        book.setAmount(amount);

        BookService bookService = new BookService();
        bookService.addBook(book);

        request.getSession().setAttribute(PAGE_JSP,page);

        response.sendRedirect(page);
    }
}
