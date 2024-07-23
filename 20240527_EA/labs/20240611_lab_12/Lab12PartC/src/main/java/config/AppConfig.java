package config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "application")
@Validated
public class AppConfig {

    @NotBlank(message = "Application name must not be blank")
    private String name;

    @NotBlank(message = "Version must not be blank")
    private String version;

    private Server server;

    private User user;

    @NotEmpty(message = "Countries list must not be empty")
    private List<String> countries;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Valid
    public static class Server {

        @NotBlank(message = "Server URL must not be blank")
        private String url;

        private String name;

        private int port;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Valid
    public static class User {

        private String firstName;

        private String lastName;

        @NotBlank(message = "Username must not be blank")
        @Size(min = 8, max = 15, message = "Username must be between 8 and 15 characters")
        private String username;

        @NotBlank(message = "Password must not be blank")
        @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
        private String password;
    }
}