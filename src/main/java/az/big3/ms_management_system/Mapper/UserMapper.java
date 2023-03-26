package az.big3.ms_management_system.Mapper;

import az.big3.ms_management_system.Dao.Entity.User;
import az.big3.ms_management_system.Dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTOList(List<User> users);

    User toEntity(UserDTO userDTO);

}

