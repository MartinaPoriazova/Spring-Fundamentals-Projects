package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.dto.UserRegisterDTO;
import bg.softuni.shoppinglist.model.entity.User;
import bg.softuni.shoppinglist.model.mapper.UserMapper;
import bg.softuni.shoppinglist.repository.UserRepository;
import bg.softuni.shoppinglist.session.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserService userService;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository, UserService userService, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean register(UserRegisterDTO userRegisterDTO) {
        User newUser = userMapper.userRegisterDTOToUser(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);

        return true;
    }

    public boolean isLoggedIn() {
        return this.currentUser.getId() > 0;
    }

    public long getLoggedUserId() {
        return this.currentUser.getId();
    }

    public boolean checkCredentials(String username, String password) {
        User user = this.userService.getUserByUsername(username);
        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }

    public void logout() {
        this.currentUser.logout();
    }
}
