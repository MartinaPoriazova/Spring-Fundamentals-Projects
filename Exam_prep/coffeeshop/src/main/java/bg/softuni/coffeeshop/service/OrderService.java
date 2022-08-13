package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.dto.AddOrderDTO;
import bg.softuni.coffeeshop.repository.CategoryRepository;
import bg.softuni.coffeeshop.repository.OrderRepository;
import bg.softuni.coffeeshop.repository.UserRepository;
import bg.softuni.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public OrderService(OrderRepository orderRepository, CategoryRepository categoryRepository, UserRepository userRepository, LoggedUser userSession) {
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void addOrder(AddOrderDTO addOrderDTO) {

    }
}
