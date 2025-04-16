package edu.miu.cs489.springsecuritydemo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {
    ADMIN_WRITE("admin:write"),
    ADMIN_READ( "admin:read"),
    MEMBER_READ( "member:read"),
    MEMBER_WRITE( "member:write");


    private final String permission;

}
