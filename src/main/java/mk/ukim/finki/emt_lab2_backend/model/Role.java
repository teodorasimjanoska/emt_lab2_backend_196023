package mk.ukim.finki.emt_lab2_backend.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_LIBRARIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
