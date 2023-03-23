package com.minidnd.controller;

import com.minidnd.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterController.class)
class CharacterControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CharacterService characterService;

    void checkIfURLStatusIsOk(String url) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get(url))
                .andExpect(status().isOk())
        ;}

    @Test
    void addCharacter() {
    }

    @Test
    void findAllCharacters() throws Exception {
        checkIfURLStatusIsOk("/");
    }

    @Test
    void findCharacterByName() {
    }

    @Test
    void updateCharacter() {
    }

    @Test
    void deleteCharacter() {
    }
}