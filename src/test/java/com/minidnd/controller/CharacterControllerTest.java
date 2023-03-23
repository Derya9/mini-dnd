package com.minidnd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minidnd.character.Character;
import com.minidnd.character.CharacterClass;
import com.minidnd.character.Race;
import com.minidnd.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterController.class)
class CharacterControllerTest {
    @MockBean
    CharacterService characterService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    String url = "/characters";
    Character character = new Character("Ella", Race.HUMAN, CharacterClass.MAGE);


    @Test
    void addCharacter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(character)))
                .andExpect(status().isOk());

        Mockito.verify(characterService).addCharacter(character);
    }

    @Test
    void findAllCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(characterService).getCharacters();
    }

    @Test
    void findCharacterByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/characters/Lucy")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(characterService).getCharacterByName("Lucy");

    }

    @Test
    void updateCharacter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(character)))
                .andExpect(status().isOk());

        Mockito.verify(characterService).updateCharacter(character);


    }

    @Test
    void deleteCharacter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/characters/Lucy")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(characterService).deleteCharacter("Lucy");

    }
}