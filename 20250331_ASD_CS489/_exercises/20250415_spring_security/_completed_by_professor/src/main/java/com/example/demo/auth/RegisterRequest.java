package com.example.demo.auth;

import com.example.demo.user.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role
) {
}
