package be.bstorm.springbookmvc.pl.controllers.security;

import be.bstorm.springbookmvc.bll.services.security.AuthService;
import be.bstorm.springbookmvc.pl.models.user.UserRegisterForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String getLogin(Authentication authentication) {
        if(authentication != null) return "redirect:/";
        return "auth/login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {

        model.addAttribute("form",new UserRegisterForm());
        return "auth/register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("form") UserRegisterForm form,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("form",form);
            return "auth/register";
        }
        authService.register(form.toEntity());
        return "redirect:/login?registered";
    }
}
