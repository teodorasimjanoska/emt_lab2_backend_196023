package mk.ukim.finki.emt_lab2_backend.service;

import mk.ukim.finki.emt_lab2_backend.model.User;

public interface AuthService {
    User login(String username, String password);
}
