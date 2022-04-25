package mk.ukim.finki.emt_lab2_backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    @Enumerated(EnumType.STRING)
    @ManyToOne
    private Category category;

    @ManyToOne
    private Author author;

    public Book(String name, Category category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }

    public Book() {

    }
}
