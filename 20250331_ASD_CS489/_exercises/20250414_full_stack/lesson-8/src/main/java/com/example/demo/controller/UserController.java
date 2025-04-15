package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String users(Model model) {
        // fetch all users
        List<UserResponseDto> users = userService.findAllUsers();

        model.addAttribute("userResponseDTOs", users);

        return "users";
    }

    @GetMapping("/sign-up")
    public String user(Model model) {
        model.addAttribute("userRequestDTO", new UserRequestDto(null, null, null, null));

        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String user(@Valid @ModelAttribute UserRequestDto userRequestDto, RedirectAttributes redirectAttributes) {
        UserResponseDto userResponseDTO = userService.createUser(userRequestDto);

        redirectAttributes.addFlashAttribute(
                "success", String.format("%s has been added successfully", userResponseDTO.username()));

        return "redirect:/api/v1/users";
    }

    @GetMapping("/edit-user/{username}")
    public String editUser(@PathVariable String username, Model model) {
        UserResponseDto userResponseDto = userService.findUserByUsername(username);

        UserRequestDto userRequestDto = new UserRequestDto(null, null, userResponseDto.username(), null);

        model.addAttribute("userRequestDTO", userRequestDto);

        return "edit-user";
    }

    @PutMapping("/edit-user/{username}")
    public String editUser(
            @PathVariable String username,
            @Valid @ModelAttribute UserRequestDto userRequestDto,
            RedirectAttributes redirectAttributes
                          ) {
        userService.updateUser(username, userRequestDto);

        redirectAttributes.addFlashAttribute("success", String.format("%s updated successfully", username));

        return "redirect:/api/v1/users";
    }
}
