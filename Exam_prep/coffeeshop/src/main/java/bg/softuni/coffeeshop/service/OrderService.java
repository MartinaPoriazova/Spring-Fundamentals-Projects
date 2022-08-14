package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.dto.AddOrderDTO;
import bg.softuni.coffeeshop.model.entity.Order;
import bg.softuni.coffeeshop.model.entity.User;
import bg.softuni.coffeeshop.repository.OrderRepository;
import bg.softuni.coffeeshop.repository.UserRepository;
import bg.softuni.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final CategoryService categoryService;
    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public OrderService(OrderRepository orderRepository, AuthService authService, CategoryService categoryService, UserRepository userRepository, LoggedUser userSession) {
        this.orderRepository = orderRepository;
        this.authService = authService;
        this.categoryService = categoryService;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void addOrder(AddOrderDTO addOrderDTO) {
        Order order = new Order();
        order.setName(addOrderDTO.getName());
        order.setPrice(addOrderDTO.getPrice());
        order.setOrderTime(addOrderDTO.getOrderTime());
        order.setDescription(addOrderDTO.getDescription());
        order.setCategory(this.categoryService.findByName(addOrderDTO.getCategory().getName()));

        User employee = this.authService.findById(this.userSession.getId());

        order.setEmployee(employee);

        this.orderRepository.save(order);
    }
}
