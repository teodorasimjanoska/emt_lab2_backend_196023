package mk.ukim.finki.emt_lab2_backend.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception.");
    }
}
