package be.bstorm.springbookmvc.pl.models.book;

import be.bstorm.springbookmvc.bll.models.BookFormBusiness;
import be.bstorm.springbookmvc.dl.entities.Author;
import be.bstorm.springbookmvc.dl.entities.Book;
import be.bstorm.springbookmvc.il.validators.BookWithAuthor;
import be.bstorm.springbookmvc.pl.models.author.AuthorForm;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@BookWithAuthor
@NoArgsConstructor @AllArgsConstructor
public class BookForm {

    @NotBlank
    private String isbn;
    @NotBlank
    private String title;

    private String description;

    private LocalDate publishedDate;

    private Long authorId;

    private AuthorForm author;

    public BookFormBusiness toBusiness(){
        return new BookFormBusiness(isbn,
                title,
                description,
                publishedDate,
                authorId,
                author == null ? null : author.toEntity());
    }

    public static BookForm fromEntity(Book book){
        return new BookForm(book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getPublicationDate(),
                book.getAuthor().getId(),
                AuthorForm.fromEntity(book.getAuthor()));
    }
}
