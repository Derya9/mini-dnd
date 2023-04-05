package me.derya.minidnd.api.endpoint;

import me.derya.minidnd.logic.CharacterService;
import me.derya.minidnd.persistence.Character;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterEndpoint {
    private final CharacterService characterService;

    public CharacterEndpoint(CharacterService characterService) {
        this.characterService = characterService;
    }
    
    @GetMapping
    List<Character> findAll(){
        return characterService.findAll();
    }
}
