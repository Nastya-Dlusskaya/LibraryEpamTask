package by.epam.library.model.command.util;

public class PageFactory {

    private static final String ADMIN = "admin";
    private static final String PATH_PAGE_ADMIN = "path.page.admin";
    private static final String ADMIN_TABLE = "admin_table";
    private static final String PATH_PAGE_ADMIN_TABLE = "path.page.admin_table";
    private static final String ADD_AUTHOR_OR_PUBLISHER = "show_add_author_or_publisher";
    private static final String PATH_PAGE_ADMIN_ADD_AUTHOR_OR_PUBLISHER = "path.page.admin_add_author_or_publisher";
    private static final String ADD_OR_EDIT_BOOK = "show_add_or_edit_book";
    private static final String PATH_PAGE_ADMIN_ADD_OR_EDIT_BOOK = "path.page.admin_add_or_edit_book";
    private static final String ADD_OR_EDIT_PERSON = "show_add_or_edit_person";
    private static final String PATH_PAGE_ADMIN_ADD_OR_EDIT_PERSON = "path.page.admin_add_or_edit_person";
    private static final String READER = "reader";
    private static final String PATH_PAGE_READER = "path.page.reader";
    private static final String LIBRARIAN = "librarian";
    private static final String PATH_PAGE_LIBRARIAN = "path.page.librarian";
    private static final String READER_LIST = "reader_list";
    private static final String PATH_PAGE_READER_LIST = "path.page.reader_list";
    private static final String PATH_PAGE_LOGIN = "path.page.login";
    private static final String CHANGE_LOGIN_AND_PASSWORD = "change_login_and_password";
    private static final String PATH_PAGE_READER_CHANGE_LOGIN_AND_PASSWORD = "path.page.reader.change_login_and_password";

    public String createPage(String typePage) {
        switch (typePage) {
            case ADMIN:
                return ConfigurationManager.getProperty(PATH_PAGE_ADMIN);
            case ADMIN_TABLE:
                return ConfigurationManager.getProperty(PATH_PAGE_ADMIN_TABLE);
            case ADD_AUTHOR_OR_PUBLISHER:
                return ConfigurationManager.getProperty(PATH_PAGE_ADMIN_ADD_AUTHOR_OR_PUBLISHER);
            case ADD_OR_EDIT_BOOK:
                return ConfigurationManager.getProperty(PATH_PAGE_ADMIN_ADD_OR_EDIT_BOOK);
            case ADD_OR_EDIT_PERSON:
                return ConfigurationManager.getProperty(PATH_PAGE_ADMIN_ADD_OR_EDIT_PERSON);
            case READER:
                return ConfigurationManager.getProperty(PATH_PAGE_READER);
            case LIBRARIAN:
                return ConfigurationManager.getProperty(PATH_PAGE_LIBRARIAN);
            case READER_LIST:
                return ConfigurationManager.getProperty(PATH_PAGE_READER_LIST);
            case CHANGE_LOGIN_AND_PASSWORD:
                return ConfigurationManager.getProperty(PATH_PAGE_READER_CHANGE_LOGIN_AND_PASSWORD);
            default:
                return ConfigurationManager.getProperty(PATH_PAGE_LOGIN);
        }
    }
}
