package bg.softuni.coffeeshop.model.mapper;

import bg.softuni.coffeeshop.model.dto.UserRegisterDTO;
import bg.softuni.coffeeshop.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRegisterDtoToUser(UserRegisterDTO userRegisterDTO);
}
