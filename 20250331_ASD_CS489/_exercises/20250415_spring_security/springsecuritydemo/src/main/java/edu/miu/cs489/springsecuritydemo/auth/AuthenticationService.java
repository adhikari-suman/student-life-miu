package edu.miu.cs489.springsecuritydemo.auth;

import edu.miu.cs489.springsecuritydemo.config.JwtService;
import edu.miu.cs489.springsecuritydemo.user.User;
import edu.miu.cs489.springsecuritydemo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService            jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder       passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.username(),
                authenticationRequest.password()
        ));

        User user = (User) authentication.getPrincipal();

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        // create a User obj
        User user = new User(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                registerRequest.role()
        );

        // save it in DB
        User registeredUser = userRepository.save(user);

        // Generate token for this user
        String token = jwtService.generateToken(registeredUser);

        return new AuthenticationResponse(token);
    }
}
