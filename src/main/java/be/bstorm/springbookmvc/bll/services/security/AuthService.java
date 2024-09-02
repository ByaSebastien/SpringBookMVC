package be.bstorm.springbookmvc.bll.services.security;

import be.bstorm.springbookmvc.dl.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    void register(User user);
}
