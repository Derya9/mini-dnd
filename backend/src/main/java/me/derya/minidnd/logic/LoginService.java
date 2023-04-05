package me.derya.minidnd.logic;

import me.derya.minidnd.security.JwtGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final JwtGenerator jwtGenerator;

    public LoginService(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    public String login(Authentication authentication) {
        return jwtGenerator.generate(authentication);
    }
}
