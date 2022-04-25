package mk.ukim.finki.emt_lab2_backend.service;


import mk.ukim.finki.emt_lab2_backend.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

}
