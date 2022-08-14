package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.dto.UserLoginDTO;
import bg.softuni.coffeeshop.model.dto.UserRegisterDTO;
import bg.softuni.coffeeshop.model.entity.User;
import bg.softuni.coffeeshop.repository.UserRepository;
import bg.softuni.coffeeshop.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public AuthService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registerDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registerDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setPassword(registerDTO.getPassword());
        user.setEmail(registerDTO.getEmail());
        user.setOrders(new ArrayList<>());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> user = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.userSession.login(user.get());

        return true;
    }

    public boolean isLoggedIn() {
        return this.userSession.getId() > 0;
    }

    public long getLoggedUserId() {
        return this.userSession.getId();
    }

    public void logout() {
        this.userSession.logout();
    }

    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
