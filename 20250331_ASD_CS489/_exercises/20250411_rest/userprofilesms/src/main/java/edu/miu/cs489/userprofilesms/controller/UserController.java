package edu.miu.cs489.userprofilesms.controller;

import edu.miu.cs489.userprofilesms.dto.request.UserRequestDTO;
import edu.miu.cs489.userprofilesms.dto.response.UserResponseDTO;
import edu.miu.cs489.userprofilesms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String username ,
                                                      @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.updateUser(userRequestDTO));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
