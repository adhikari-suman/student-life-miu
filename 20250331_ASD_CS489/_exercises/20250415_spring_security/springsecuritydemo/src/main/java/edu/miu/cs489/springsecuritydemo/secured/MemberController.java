package edu.miu.cs489.springsecuritydemo.secured;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping
    @PreAuthorize("hasAuthority('admin:write')")
    public String getMember(){
        return "Member: secured end point";
    }

    @GetMapping("/admin-write")
    @PreAuthorize("hasAuthority('admin:write')")
    public String memberOnlyForAdminWrite(){
        return "Member: secured end point";
    }
}
