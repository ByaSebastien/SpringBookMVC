package be.bstorm.springbookmvc.pl.models.author;

import be.bstorm.springbookmvc.dl.entities.Author;

public record AuthorDTO(
        Long id,
        String name
) {
    public static AuthorDTO fromEntity(Author author) {
        return new AuthorDTO(author.getId(), author.getName());
    }
}
