package edu.miu.cs489.springsecuritydemo.config;

import edu.miu.cs489.springsecuritydemo.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@Data
public class JwtService {
    private final String JWT_SECRET_KEY;

    public JwtService(@Value("${jwt.secretKey}") String secretKey) {
        this.JWT_SECRET_KEY = secretKey;
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .signWith(signInKey())
                .issuer("suman-adhikari.com.np")
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 24))
                .subject(userDetails.getUsername())
                .claim("authorities", populateAuthorities(userDetails.getAuthorities()))
                .compact();
    }

    private SecretKey signInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET_KEY));
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    public Claims parseSignedClaims(String token) {
        return Jwts.parser()
            .verifyWith(signInKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}
