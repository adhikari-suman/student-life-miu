package edu.miu.cs489.userprofilesms.service.impl;

import edu.miu.cs489.userprofilesms.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofilesms.dto.response.UserResponseDTO;
import edu.miu.cs489.userprofilesms.exception.user.DuplicateUserException;
import edu.miu.cs489.userprofilesms.exception.user.UserNotFoundException;
import edu.miu.cs489.userprofilesms.mapper.UserMapper;
import edu.miu.cs489.userprofilesms.model.Profile;
import edu.miu.cs489.userprofilesms.model.User;
import edu.miu.cs489.userprofilesms.repository.UserRepository;
import edu.miu.cs489.userprofilesms.service.UserService;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper     userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        // Check whether user is existing or not
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDTO.username());
        if (optionalUser.isPresent()) {
            throw new DuplicateUserException("Username already exists");
        }

        User user = userMapper.userRequestDTOtoUser(userRequestDTO);

        User newUser = userRepository.save(user);

        return userMapper.userToUserResponseDTO(newUser);
    }

    @Transactional
    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDTO.username());

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException(String.format("User with username %s not found", userRequestDTO.username()));
        }

        User existingUser = optionalUser.get();
        User mappedUser = userMapper.userRequestDTOtoUser(userRequestDTO);
        mappedUser.setId(existingUser.getId());

        if(mappedUser.getPassword() != null){
            Profile existingProfile = existingUser.getProfile();
            mappedUser.getProfile().setId(existingProfile.getId());
        }

        User updatedUser = userRepository.save(mappedUser);

        return userMapper.userToUserResponseDTO(updatedUser);
    }

    @Override
    public void deleteUserByUsername(String username) {
        // this will not need transcaction as using hibernate query
//        userRepository.findByUsername(username)
//                .ifPresent(user -> userRepository.delete(user));

        // this will need transactional as using custom JPQL  deleteByUsername
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isPresent()){
            userRepository.deleteByUsername(username);
        } else {
            throw new UserNotFoundException(String.format("User with username %s not found", username));
        }
    }

    @Override
    public UserResponseDTO findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<UserResponseDTO> findAllUsers() {
        List<User> users = userRepository.findAll();

        return userMapper.usersToUserResponseDTOs(users);
    }
}
