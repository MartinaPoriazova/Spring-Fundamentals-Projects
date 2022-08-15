package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.entity.User;
import bg.softuni.shoppinglist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }
}
