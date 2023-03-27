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

    @GetMapping("{id}")
    public Optional<Character> findCharacterById(@PathVariable Long id) {
        return service.getCharacterById(id);
    }

    @PutMapping
    public Character updateCharacterByName(@RequestBody Long id, String name) {
        return service.updateCharacterNameById(id, name);
    }

    @DeleteMapping("{id}")
    public void deleteCharacter(@PathVariable Long id) {
        service.deleteCharacter(id);
    }

}
