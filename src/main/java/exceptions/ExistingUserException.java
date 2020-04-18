package exceptions;

public class ExistingUserException extends Exception {
    public ExistingUserException() { }

    public ExistingUserException(String message) {
        super(message);
    }
}
