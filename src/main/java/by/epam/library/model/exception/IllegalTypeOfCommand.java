package by.epam.library.model.exception;

public class IllegalTypeOfCommand extends Exception {

    public IllegalTypeOfCommand(String message) {
        super(message);
    }

    public IllegalTypeOfCommand(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTypeOfCommand(Throwable cause) {
        super(cause);
    }

    public IllegalTypeOfCommand(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
