package mk.ukim.finki.emt_lab2_backend.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private String name;

    private Long category;

    private Long author;

    public BookDto() {
    }

    public BookDto(String name, Long category, Long author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }
}
