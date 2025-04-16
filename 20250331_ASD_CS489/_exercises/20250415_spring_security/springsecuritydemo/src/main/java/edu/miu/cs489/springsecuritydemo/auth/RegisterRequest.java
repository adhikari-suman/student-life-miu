package edu.miu.cs489.springsecuritydemo.auth;

import edu.miu.cs489.springsecuritydemo.user.Role;

public record RegisterRequest(String firstName,
                              String lastName,
                              String username,
                              String password,
                              Role role
                              ) {
}