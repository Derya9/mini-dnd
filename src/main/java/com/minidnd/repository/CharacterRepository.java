package com.minidnd.repository;

import com.minidnd.character.Character;
import com.minidnd.character.CharacterClass;
import com.minidnd.character.Race;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {
    private List<Character> characterList;

    public CharacterRepository(List<Character> characterList) {
        this.characterList = characterList;
    }

    @PostConstruct
    private void initialize() {
        characterList = List.of(
                new Character("Lucy", Race.DWARF, CharacterClass.DRUID),
                new Character("Karol", Race.ELF, CharacterClass.FIGHTER),
                new Character("Drake", Race.HUMAN, CharacterClass.MAGE)
        );
    }

    // CREATE
    public Character addCharacter(Character character) {
        characterList.add(character);
        return character;
    }

    // READ
    public List<Character> getAllCharacters() {
        return characterList;
    }

    public Optional<Character> findByName(String name) {
        return characterList.stream()
                .filter(character -> character.getName().equals(name))
                .findFirst();
    }

    // UPDATE
    public Character update(Character character) {
        delete(character.getName());
        addCharacter(character);
        return character;
    }

    // DELETE
    public void delete(String name) {
        characterList.removeIf(x -> x.getName().equals(name));
    }

}
