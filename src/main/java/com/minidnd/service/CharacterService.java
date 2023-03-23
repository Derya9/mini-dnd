package com.minidnd.service;

import com.minidnd.character.Character;
import com.minidnd.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character addCharacter(Character character) {
        return characterRepository.addCharacter(character);
    }

    public List<Character> getCharacters() {
        return characterRepository.getAllCharacters();
    }

    public Optional<Character> getCharacterByName(String name) {
        return characterRepository.findByName(name);
    }

    public void deleteCharacter(String name) {
        characterRepository.delete(name);
    }

    public Character updateCharacter(Character character) {
        return characterRepository.update(character);
    }

}
