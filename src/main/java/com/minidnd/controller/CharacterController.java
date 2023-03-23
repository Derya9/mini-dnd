package com.minidnd.controller;

import com.minidnd.character.Character;
import com.minidnd.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return service.addCharacter(character);
    }

    @GetMapping()
    public List<Character> findAllCharacters() {
        return service.getCharacters();
    }

    @GetMapping("/{name}")
    public Optional<Character> findCharacterByName(@PathVariable String name) {
        return service.getCharacterByName(name);
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
