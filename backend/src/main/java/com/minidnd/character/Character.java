package com.minidnd.character;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table
public class Character {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private Race race;
    @Column
    private CharacterClass characterClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character(Long id, String name, Race race, CharacterClass characterClass) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) && race == character.race && characterClass == character.characterClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, race, characterClass);
    }
}
