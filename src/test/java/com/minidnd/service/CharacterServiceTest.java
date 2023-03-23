package com.minidnd.service;

import com.minidnd.character.Character;
import com.minidnd.character.CharacterClass;
import com.minidnd.character.Race;
import com.minidnd.repository.CharacterRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CharacterServiceTest { // behavioral testing

    CharacterRepository characterRepository = mock(CharacterRepository.class);
    CharacterService characterService = new CharacterService(characterRepository);
    Character character = new Character("Ella", Race.ELF, CharacterClass.MAGE);

    @Test
    void saveCharacter() {
        characterService.addCharacter(character);

        verify(characterRepository).addCharacter(character);
    }

    @Test
    void getCharacters() {
        characterService.getCharacters();

        verify(characterRepository).getAllCharacters();
    }

    @Test
    void getCharacterByName() {
        characterService.getCharacterByName(character.getName());

        verify(characterRepository).findByName(character.getName());
    }

    @Test
    void deleteCharacter() {
        characterService.deleteCharacter(character.getName());

        verify(characterRepository).delete(character.getName());
    }

    @Test
    void updateCharacter() {
        characterService.updateCharacter(character);

        verify(characterRepository).update(character);
    }
}