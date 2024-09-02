package be.bstorm.springbookmvc.pl.models.book;

import be.bstorm.springbookmvc.dl.entities.Book;

public record BookShortDTO(
        Long id,
        String isbn,
        String title,
        String authorName
) {

    public static BookShortDTO fromEntity(Book book){
        return new BookShortDTO(book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor().getName());
    }
}
