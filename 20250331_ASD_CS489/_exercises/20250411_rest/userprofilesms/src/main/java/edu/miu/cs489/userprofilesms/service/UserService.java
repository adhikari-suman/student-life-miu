package edu.miu.cs489.userprofilesms.service;

import edu.miu.cs489.userprofilesms.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofilesms.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
    void deleteUserByUsername(String username);
    UserResponseDTO findUserByUsername(String username);
    List<UserResponseDTO> findAllUsers();
}
