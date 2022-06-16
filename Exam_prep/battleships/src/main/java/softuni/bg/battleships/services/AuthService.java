package softuni.bg.battleships.services;

import org.springframework.stereotype.Service;
import softuni.bg.battleships.models.User;
import softuni.bg.battleships.models.dtos.UserRegisterDTO;
import softuni.bg.battleships.repositories.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public boolean register(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmedPassword())) {
            return false;
        }
        User user = new User();

        this.userRepository.save(user);
        user.setUsername(userRegisterDTO.getUsername());
        user.setFullName(userRegisterDTO.getFullName());
        user.setPassword(userRegisterDTO.getPassword());
        user.setEmail(userRegisterDTO.getEmail());

        return true;
    }

}
