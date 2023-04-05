package me.derya.minidnd.api.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageEndpoint {

    @GetMapping
    String message() {
        return "HI!";
    }
}
