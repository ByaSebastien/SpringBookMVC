package be.bstorm.springbookmvc.dal;

import be.bstorm.springbookmvc.dal.repositories.BookRepository;
import be.bstorm.springbookmvc.dal.repositories.UserRepository;
import be.bstorm.springbookmvc.dl.entities.Author;
import be.bstorm.springbookmvc.dl.entities.Book;
import be.bstorm.springbookmvc.dl.entities.User;
import be.bstorm.springbookmvc.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            User user = new User("Seb", passwordEncoder.encode("Test1234="), true, Set.of(UserRole.ADMIN, UserRole.USER));
            userRepository.save(user);
        }
        if (bookRepository.count() == 0) {
            List<Book> books = Arrays.asList(
                    new Book("978-3-16-148410-0",
                            "Les Secrets de l'Univers",
                            "Une exploration des mystères de l'espace et du temps.",
                            LocalDate.of(2010, 5, 12),
                            new Author("Jean Dupont",
                                    LocalDate.of(1965, 4, 21))),

                    new Book("978-1-23-456789-7",
                            "L'Art de la Guerre Moderne",
                            "Analyse des stratégies militaires contemporaines.",
                            LocalDate.of(2005, 11, 3),
                            new Author("Marie Durant",
                                    LocalDate.of(1978, 9, 14))),

                    new Book("978-0-19-852663-6",
                            "Voyage au Centre de la Terre",
                            "Une aventure au cœur de notre planète.",
                            LocalDate.of(1999, 8, 29),
                            new Author("Paul Martin",
                                    LocalDate.of(1970, 6, 8))),

                    new Book("978-0-14-044913-6",
                            "La Magie des Étoiles",
                            "Un conte enchanteur sur la beauté du cosmos.",
                            LocalDate.of(2015, 12, 18),
                            new Author("Clara Bernard",
                                    LocalDate.of(1985, 2, 27))),

                    new Book("978-0-06-112008-4",
                            "Les Mémoires d'un Explorateur",
                            "Récit d'un explorateur à travers le monde.",
                            LocalDate.of(1997, 4, 10),
                            new Author("Antoine Leblanc",
                                    LocalDate.of(1950, 1, 3))),

                    new Book("978-0-670-81302-8",
                            "La Philosophie de l'Esprit",
                            "Une réflexion sur la nature de la conscience.",
                            LocalDate.of(2003, 7, 23),
                            new Author("Sophie Lambert",
                                    LocalDate.of(1980, 11, 22))),

                    new Book("978-0-553-21247-4",
                            "Les Enfants du Futur",
                            "Un roman d'anticipation sur les générations à venir.",
                            LocalDate.of(2020, 10, 5),
                            new Author("Lucien Moreau",
                                    LocalDate.of(1990, 5, 15))),

                    new Book("978-0-345-39180-3",
                            "Le Chant des Sirènes",
                            "Une légende maritime sur les créatures mythiques.",
                            LocalDate.of(2012, 3, 27),
                            new Author("Elise Dubois",
                                    LocalDate.of(1975, 9, 30))),

                    new Book("978-1-85798-218-5",
                            "L'Énigme du Sphinx",
                            "Un mystère archéologique en Égypte ancienne.",
                            LocalDate.of(2008, 6, 17),
                            new Author("Michel Girard",
                                    LocalDate.of(1962, 8, 13))),

                    new Book("978-0-7432-7356-5",
                            "L'Ombre du Temps",
                            "Un thriller captivant sur les paradoxes temporels.",
                            LocalDate.of(2018, 1, 9),
                            new Author("Hélène Fournier",
                                    LocalDate.of(1982, 12, 19)))
            );
            bookRepository.saveAll(books);
        }
    }
}
