package com.minidnd.repository;

import com.minidnd.character.Character;
import com.minidnd.character.CharacterClass;
import com.minidnd.character.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryTest {

    List<Character> characters = new ArrayList<>();
    CharacterRepository characterRepository = new CharacterRepository(characters);
    Character character = new Character("Ella", Race.ELF, CharacterClass.MAGE);


    @AfterEach
    void deleteRepo() {
        characters.clear();
    }

    @Test
    void save() {
        Character result = characterRepository.save(character);

        assertEquals(character, result);
        assertTrue(characters.contains(character));
    }

    @Test
    void getAllCharacters() {
        characters.add(character);

        List<Character> result = characterRepository.getAllCharacters();
        List<Character> expected = List.of(character);

        assertIterableEquals(expected, result);
    }

    @Test
    void findByName() {
        characters.add(character);

        Optional<Character> result = characterRepository.findByName(character.getName());
        Optional<Character> expected = Optional.ofNullable(character);

        assertEquals(expected,result);
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
        characters.add(character);

        characterRepository.delete(character.getName());

        assertTrue(characters.isEmpty());
    }
}