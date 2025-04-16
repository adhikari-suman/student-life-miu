package edu.miu.cs489.springsecuritydemo.config;

import edu.miu.cs489.springsecuritydemo.user.Permission;
import edu.miu.cs489.springsecuritydemo.user.Role;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtFilter              jwtFilter;
    private final AuthenticationProvider authneticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HttpSession httpSession) throws Exception {


        http.csrf(CsrfConfigurer::disable)
            .authorizeHttpRequests(

                    authorizeRequests -> authorizeRequests.requestMatchers("/api/v1/auth/*")
                                                          .permitAll()
                                                          .requestMatchers("/api/v1/management/**")
                                                          .hasAnyRole(Role.ADMIN.name(), Role.MEMBER.name())
                                                          .requestMatchers("/api/v1/admin/**")
                                                          .hasRole(Role.ADMIN.name())
//                                                          .requestMatchers("/api/v1/management/admin-write")
//                                                          .hasAuthority(Permission.ADMIN_WRITE.getPermission())
                                                          .anyRequest()
                                                          .authenticated())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .authenticationProvider(authneticationProvider)
            .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
