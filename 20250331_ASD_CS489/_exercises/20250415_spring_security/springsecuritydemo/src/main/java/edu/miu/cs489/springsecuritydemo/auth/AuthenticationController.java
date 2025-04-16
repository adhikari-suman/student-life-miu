package edu.miu.cs489.springsecuritydemo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest registerRequest
                                                              ){
        AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(
            @RequestBody AuthenticationRequest authenticationRequest
                                                                  ){
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);

        return ResponseEntity.status(HttpStatus.OK).body(authenticationResponse);
    }

}
