package mk.ukim.finki.emt_lab2_backend.service;

import mk.ukim.finki.emt_lab2_backend.model.Role;
import mk.ukim.finki.emt_lab2_backend.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword,
                  String name, String surname, Role role);
}
