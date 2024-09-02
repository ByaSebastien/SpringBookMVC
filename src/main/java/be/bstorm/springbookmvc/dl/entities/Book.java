package be.bstorm.springbookmvc.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode(callSuper = false)
public class Book extends BaseEntity<Long> {

    @Column(nullable = false,unique = true)
    private String isbn;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = true)
    private String description;

    @Temporal(TemporalType.DATE)
    private LocalDate publicationDate;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Author author;
}
