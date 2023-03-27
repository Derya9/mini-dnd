package com.minidnd.repository;

import com.minidnd.character.Character;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
    @Transactional
    @Modifying
    @Query("update Character c set c.name = ?1 where c.id = ?2")
    Character updateNameById(String name, Long id);

}