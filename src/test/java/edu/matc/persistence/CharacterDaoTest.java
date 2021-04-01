package edu.matc.persistence;

import edu.matc.entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterDaoTest {

    CharacterDao dao;
    int testCharId = 0;

    @BeforeEach
    void setUp() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new CharacterDao();
        Character newCharacter = new Character();
        newCharacter.setCharacterName("test");
        newCharacter.setActorName("test");
        newCharacter.setMemorableQuote("test");
        testCharId = dao.createCharacter(newCharacter);
    }

//    @Test
//    void getAllCharacters() {
//        List<Character> characters = dao.getAllCharacters();
//        assertEquals(1, characters.size());
//    }
//
//    @Test
//    void getCharacterByName() {
//        List<Character> characters = dao.getCharacterByName("Michael Scott");
//        assertEquals(1, characters.size());
//    }
//
//    @Test
//    void createCharacter() {
//        int numberOfCharacters = dao.getAllCharacters().size();
//        Character newCharacter = new Character();
//        newCharacter.setCharacterName("Chair Model");
//        newCharacter.setActorName("Brooke Dillman");
//        newCharacter.setMemorableQuote("none. She just sits in the chair...");
//        dao.createCharacter(newCharacter);
//        assertEquals(numberOfCharacters + 1, dao.getAllCharacters().size());
//    }
//
//    @Test
//    void deleteCharacter() {
//        Character testCharacter = dao.getCharacterById(testCharId);
//        assertEquals(true, testCharacter != null);
//        dao.deleteCharacter(testCharacter);
//        assertEquals(null, dao.getCharacterById(testCharId));
//    }
//
//    @Test
//    void updateCharacter() {
//        Character testCharacter = dao.getCharacterById(testCharId);
//        testCharacter.setCharacterName("newTestName");
//        dao.updateCharacter(testCharacter);
//        List<Character> updatedCharacter = dao.getCharacterByName("newTestName");
//        assertEquals(1, updatedCharacter.size());
//    }

}