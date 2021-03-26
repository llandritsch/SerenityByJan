package edu.matc.persistence;

import edu.matc.entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterDaoTest {

    CharacterDao dao;

    @BeforeEach
    void setUp() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();

        dao = new CharacterDao();
    }

    @Test
    void getAllCharacters() {
        List<Character> characters = dao.getAllCharacters();
        assertEquals(1, characters.size());
    }
}