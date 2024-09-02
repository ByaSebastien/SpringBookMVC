package be.bstorm.springbookmvc.pl.models.user;

import be.bstorm.springbookmvc.dl.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    public User toEntity(){
        return new User(this.username, this.password);
    }
}
