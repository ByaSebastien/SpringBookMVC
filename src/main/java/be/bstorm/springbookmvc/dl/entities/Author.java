package be.bstorm.springbookmvc.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode(callSuper = false)
@AttributeOverride(name = "id",column = @Column(name = "author_id"))
public class Author extends BaseEntity<Long>{

    @Column(nullable = false,length = 100)
    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
}
