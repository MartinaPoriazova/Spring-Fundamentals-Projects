package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.model.dto.UserLoginDTO;
import bg.softuni.shoppinglist.model.dto.UserRegisterDTO;
import bg.softuni.shoppinglist.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO initRegisterDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO initLoginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register() {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || !this.authService.register(registerDTO)) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/register";
        }

//        if (authService.existsByUsername(registerDTO.getUsername())) {
//            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
//            redirectAttributes.addFlashAttribute("isUsernameTaken", true);
//            return "redirect:/register";
//        }
//
//        if (authService.existsByEmail(registerDTO.getEmail())) {
//            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
//            redirectAttributes.addFlashAttribute("isEmailTaken", true);
//            return "redirect:/register";
//        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }
        boolean badCredentials = this.authService.checkCredentials(loginDTO.getUsername(), loginDTO.getPassword());
        if (!badCredentials) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }
        this.authService.login(loginDTO.getUsername());
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        this.authService.logout();

        return "redirect:/";
    }
}
