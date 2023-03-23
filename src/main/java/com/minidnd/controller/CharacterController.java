package com.minidnd.controller;

import com.minidnd.character.Character;
import com.minidnd.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return service.saveCharacter(character);
    }

    @GetMapping()
    public List<Character> findAllCharacters() {
        return service.getCharacters();
    }

    @GetMapping("{name}")
    public Character findCharacterByName(@PathVariable String name) {
        return service.getCharacterByName(name).orElseThrow();
    }

    @PutMapping
    public Character updateCharacter(@RequestBody Character character) {
        return service.updateCharacter(character);
    }

    @DeleteMapping("{name}")
    public void deleteCharacter(@PathVariable String name) {
        service.deleteCharacter(name);
    }

}
