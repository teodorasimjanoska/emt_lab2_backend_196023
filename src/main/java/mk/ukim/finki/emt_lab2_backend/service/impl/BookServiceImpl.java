package mk.ukim.finki.emt_lab2_backend.service.impl;

import mk.ukim.finki.emt_lab2_backend.model.Author;
import mk.ukim.finki.emt_lab2_backend.model.Book;
import mk.ukim.finki.emt_lab2_backend.model.Category;
import mk.ukim.finki.emt_lab2_backend.model.dto.BookDto;
import mk.ukim.finki.emt_lab2_backend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt_lab2_backend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt_lab2_backend.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.emt_lab2_backend.repository.AuthorRepository;
import mk.ukim.finki.emt_lab2_backend.repository.BookRepository;
import mk.ukim.finki.emt_lab2_backend.repository.CategoryRepository;
import mk.ukim.finki.emt_lab2_backend.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> save(String name, Long categoryId, Long authorId) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        return Optional.of(this.bookRepository.save(new Book(name, category, author)));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(bookDto.getCategory()));
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), category, author);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Long categoryId, Long authorId) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());

        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(bookDto.getCategory()));
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setCategory(category);
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
