package com.minidnd;

import com.minidnd.repository.CharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    CharacterRepository characterRepository;




    public static void main(String[] args) {
        SpringApplication.run(App.class, args);


    }
}
