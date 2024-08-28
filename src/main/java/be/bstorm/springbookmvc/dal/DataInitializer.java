package be.bstorm.springbookmvc.dal;

import be.bstorm.springbookmvc.dal.repositories.UserRepository;
import be.bstorm.springbookmvc.dl.entities.User;
import be.bstorm.springbookmvc.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

            User user = new User("Seb", passwordEncoder.encode("Test1234="), true, Set.of(UserRole.ADMIN,UserRole.USER));
            userRepository.save(user);
    }
}
