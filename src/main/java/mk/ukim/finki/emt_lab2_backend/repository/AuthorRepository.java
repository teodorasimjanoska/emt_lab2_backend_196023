package mk.ukim.finki.emt_lab2_backend.repository;

import mk.ukim.finki.emt_lab2_backend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
