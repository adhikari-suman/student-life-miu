package config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "application")
public class AppConfig {
    private String name;
    private String version;
    private Server server;
    private User user;
    private List<String> countries;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Server {
        private int port;
        private String name;
        private String url;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private String firstName;
        private String lastName;
        private String username;
        private String password;
    }
}
