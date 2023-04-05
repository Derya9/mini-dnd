package me.derya.minidnd.api.endpoint;

import me.derya.minidnd.logic.LoginService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication/login")
public class LoginEndpoint {
    private final LoginService loginService;

    public LoginEndpoint(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    String login(Authentication authentication) {
        return loginService.login(authentication);
    }
}
