package bg.softuni.shoppinglist.model.mapper;

import bg.softuni.shoppinglist.model.dto.UserRegisterDTO;
import bg.softuni.shoppinglist.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userRegisterDTOToUser(UserRegisterDTO registerDTO);
}
