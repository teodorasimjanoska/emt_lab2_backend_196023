package mk.ukim.finki.emt_lab2_backend.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}
