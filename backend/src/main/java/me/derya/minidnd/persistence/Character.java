package me.derya.minidnd.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "_character")
public class Character {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private CharacterRace characterRace;
    private CharacterClass characterClass;
}
