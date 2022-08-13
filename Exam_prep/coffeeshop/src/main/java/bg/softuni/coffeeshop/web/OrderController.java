package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.model.dto.AddOrderDTO;
import bg.softuni.coffeeshop.service.AuthService;
import bg.softuni.coffeeshop.service.OrderService;
import bg.softuni.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {
    private final AuthService authService;
    private final OrderService orderService;
    private final LoggedUser loggedUser;

    public OrderController(AuthService authService, OrderService orderService, LoggedUser loggedUser) {
        this.authService = authService;
        this.orderService = orderService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("addOrderDTO")
    public AddOrderDTO initAddOrderDTO() {
        return new AddOrderDTO();
    }

    @GetMapping("/order-add")
    public String register() {
        if (this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        return "order-add";
    }

    @PostMapping("/offer-add")
    public String addOffer(@Valid AddOrderDTO addOrderDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addOrderDTO", addOrderDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOrderDTO", bindingResult);

            return "redirect:/offer-add";
        }

        this.orderService.addOrder(addOrderDTO);

        return "redirect:/home";
    }
}
