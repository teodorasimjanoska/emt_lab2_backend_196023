package mk.ukim.finki.emt_lab2_backend.service.impl;

import mk.ukim.finki.emt_lab2_backend.model.Category;
import mk.ukim.finki.emt_lab2_backend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }
}
