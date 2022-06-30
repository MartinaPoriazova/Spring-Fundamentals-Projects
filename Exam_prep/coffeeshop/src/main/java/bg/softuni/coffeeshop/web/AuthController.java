package bg.softuni.coffeeshop.web;
import bg.softuni.coffeeshop.model.dto.UserRegisterDTO;
import bg.softuni.coffeeshop.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO initRegistrationDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register() {

        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "register";
    }


}
