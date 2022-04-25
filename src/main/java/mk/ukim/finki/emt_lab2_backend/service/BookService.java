package mk.ukim.finki.emt_lab2_backend.service;

import mk.ukim.finki.emt_lab2_backend.model.Book;
import mk.ukim.finki.emt_lab2_backend.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(String name, Long category, Long author);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Long categoryId, Long authorId);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);
}
