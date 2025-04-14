package edu.miu.cs489.userprofilesms.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProfileRequestDTO(
        @NotBlank(message = "First name cannot be blank/empty/null")
        String firstName,
        @NotBlank(message = "Last name cannot be blank/empty/null")
        String lastName,
        @NotNull(message = "Date of birth cannot be null")
        LocalDate dateOfBirth,
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        String email,
        @NotBlank(message = "Phone number cannot be blank/empty/null")
        String phoneNumber,
        @NotBlank(message = "Bio cannot be blank/empty/null")
        String bio) {
}
