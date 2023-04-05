package com.minidnd.service;

import com.minidnd.character.Character;
import com.minidnd.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }

    public List<Character> getCharacters() {
        return (List<Character>) characterRepository.findAll();
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }


}
