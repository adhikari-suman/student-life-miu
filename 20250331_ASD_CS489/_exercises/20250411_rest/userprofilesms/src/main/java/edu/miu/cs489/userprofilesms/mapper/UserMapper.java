package edu.miu.cs489.userprofilesms.mapper;

import edu.miu.cs489.userprofilesms.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofilesms.dto.response.UserResponseDTO;
import edu.miu.cs489.userprofilesms.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProfileMapper.class)
public interface UserMapper {
    @Mapping(source="profileRequestDTO", target = "profile")
    User userRequestDTOtoUser(UserRequestDTO userRequestDTO);

    @Mapping(source = "profile", target = "profileResponseDTO")
    UserResponseDTO userToUserResponseDTO(User user);

    @Mapping(source = "profile", target = "profileResponseDTO")
    List<UserResponseDTO> usersToUserResponseDTOs(List<User> users);
}
