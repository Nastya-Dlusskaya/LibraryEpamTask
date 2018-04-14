package by.epam.library.model.command.common;

public enum CommandEnum {
    LOGIN("login"), LIBRARIAN("librarian"), READER("reader"), ADMIN("admin"), LOGOUT("logout"), HAND("hand"),
    SEARCH_BOOK("search_book"), ORDER("order"), ARCHIVE_BOOK("archive_book"), CURRENT_BOOK("current_book"),
    ORDERED_BOOK("ordered_book"), SHOW_PAGE_RETURN_BOOK("show_page_return_book"), RETURN_BOOK("return_book"),
    SHOW_SEARCH_PERSON("show_search_person"), SHOW_SEARCH_BOOK("show_search_book"),
    SHOW_ADD_OR_EDIT_PERSON("show_add_or_edit_person"), SHOW_ADD_OR_EDIT_BOOK("show_add_or_edit_book"),
    SHOW_ADD_AUTHOR("show_add_author"), SHOW_ADD_PUBLISHER("show_add_publisher"), ADD_AUTHOR("add_author"),
    ADD_PUBLISHER("add_publisher"), ADD_BOOK("add_book"), POSTPONE("postpone"), CANCEL_ORDER("cancel_order"),
    DELETE_BOOK("delete_book"), DELETE_PERSON("delete_person"), EDIT_BOOK("edit_book"), EDIT_PERSON("edit_person");

    String value;

    public String getValue() {
        return value;
    }

    CommandEnum(String value) {
        this.value = value;
    }

    public static CommandEnum getCommandEnum(String value) {
        CommandEnum[] commands = CommandEnum.values( );
        for (CommandEnum command : commands) {
            String commandValue = command.value;
            if (value.equals(commandValue)) {
                return command;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
