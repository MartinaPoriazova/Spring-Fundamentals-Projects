package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.service.AuthService;
import bg.softuni.coffeeshop.service.OrderService;
import bg.softuni.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    private final AuthService authService;
    private final OrderService orderService;
    private final LoggedUser loggedUser;

    public HomeController(AuthService authService, OrderService orderService, LoggedUser loggedUser) {
        this.authService = authService;
        this.orderService = orderService;
        this.loggedUser = loggedUser;
    }


}
