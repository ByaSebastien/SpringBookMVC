package be.bstorm.springbookmvc.bll.models;

import be.bstorm.springbookmvc.dl.entities.Author;
import be.bstorm.springbookmvc.dl.entities.Book;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookFormBusiness {

    private String isbn;

    private String title;

    private String description;

    private LocalDate publishedDate;

    private Long authorId;

    private Author author;

    public Book toEntity(){
        return new Book(isbn, title, description, publishedDate, author);
    }
}
