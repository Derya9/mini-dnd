package me.derya.minidnd.api.endpoint;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication/login")
public class LoginEndpoint {
    @GetMapping
    String login(Authentication authentication) {
        return "LOGGED IN! + " + authentication.getName();
    }
}
