package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.model.dto.AddOrderDTO;
import bg.softuni.coffeeshop.model.entity.Order;
import bg.softuni.coffeeshop.service.AuthService;
import bg.softuni.coffeeshop.service.OrderService;
import bg.softuni.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final AuthService authService;
    private final OrderService orderService;

    public HomeController(AuthService authService, OrderService orderService) {
        this.authService = authService;
        this.orderService = orderService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!this.authService.isLoggedIn()) {
            return "redirect:/index";
        }

        List<Order> orders = this.orderService.findAllSorted();

        if (!model.containsAttribute("orders")) {
            model.addAttribute("orders", orders);
            model.addAttribute("totalTimeForCompletion",
                    orders
                            .stream()
                            .map(or -> or.getCategory().getNeededTime())
                            .reduce(Integer::sum)
                            .orElse(0));

            model.addAttribute("employees", this.authService.findAllUsersWithOrdersSortedByOrderCount());
        }

        return "home";
    }

    @GetMapping("/orders/ready/{id}")
    public String orderReady(@PathVariable Long id) {
        this.orderService.readyOrder(id);
        return "redirect:/home";
    }
}
