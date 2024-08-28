package be.bstorm.springbookmvc.pl.controllers.security;

import be.bstorm.springbookmvc.bll.services.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String getLogin() {
        return "auth/login";
    }
}
