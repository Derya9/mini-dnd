package me.derya.minidnd.runner;

import me.derya.minidnd.persistence.User;
import me.derya.minidnd.persistence.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserPopulator {
    @Bean
    ApplicationRunner populate(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String password = passwordEncoder.encode("el");
            User user = new User(0, "el@el.el", password, "El", Set.of());
            userRepository.save(user);
        };
    }
}
