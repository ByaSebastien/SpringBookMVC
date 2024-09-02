package be.bstorm.springbookmvc.pl.models.author;

import be.bstorm.springbookmvc.dl.entities.Author;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorForm {

    @NotBlank
    private String name;

    private LocalDate birthDate;

    public Author toEntity(){
        return new Author(name, birthDate);
    }

    public static AuthorForm fromEntity(Author author){
        return new AuthorForm(author.getName(),author.getBirthDate());
    }
}
