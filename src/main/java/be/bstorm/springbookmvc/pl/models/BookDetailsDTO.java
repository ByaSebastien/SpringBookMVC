package be.bstorm.springbookmvc.pl.models;

import be.bstorm.springbookmvc.dl.entities.Book;

import java.time.LocalDate;

public record BookDetailsDTO(
        String isbn,
        String title,
        String description,
        LocalDate publishedDate,
        String authorName
) {

    public static BookDetailsDTO fromEntity(Book book) {
        return new BookDetailsDTO(book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getPublicationDate(),
                book.getAuthor().getName());
    }
}
