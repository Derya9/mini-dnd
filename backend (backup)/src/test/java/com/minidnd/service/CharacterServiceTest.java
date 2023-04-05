package com.minidnd.service;

import com.minidnd.character.Character;
import com.minidnd.character.CharacterClass;
import com.minidnd.character.Race;
import com.minidnd.repository.CharacterRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CharacterServiceTest {

    CharacterRepository characterRepository = mock(CharacterRepository.class);
    CharacterService characterService = new CharacterService(characterRepository);
    Character character = new Character(0L,"Ella", Race.ELF, CharacterClass.MAGE);

    @Test
    void saveCharacter() {
        characterService.addCharacter(character);

        verify(characterRepository).save(character);
    }

    @Test
    void getCharacters() {
        characterService.getCharacters();

        verify(characterRepository).findAll();
    }


    @Test
    void deleteCharacter() { // NOT WORKING
        characterService.deleteCharacter(character.getId());

        verify(characterRepository).deleteById(character.getId());
    }

//    @Test
//    void updateCharacter() {
//        characterService.updateCharacterNameById( "Bob");
//
//        verify(characterRepository).updateNameById("Bob");
//    }

    @Test
    void getCharacterById() {
        characterService.getCharacterById(character.getId());

        verify(characterRepository).findById(character.getId());
    }
}