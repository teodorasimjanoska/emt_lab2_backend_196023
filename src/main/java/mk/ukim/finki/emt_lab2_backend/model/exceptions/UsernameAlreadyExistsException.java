package mk.ukim.finki.emt_lab2_backend.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super(String.format("User with username %s already exists.", username));
    }
}
