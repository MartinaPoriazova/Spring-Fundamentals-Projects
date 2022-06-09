package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(userLoginDTO.getUsername());

        if(userEntityOptional.isEmpty()) {
            LOGGER.debug("User with name [{}] not found", userLoginDTO.getUsername());
            return false;
        }

        return userEntityOptional.get().getPassword().equals(userLoginDTO.getPassword());
    }
}
