package edu.matc.persistence;

import edu.matc.entity.Character;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class CharacterDaoTest {

    CharacterDao dao;
    int testCharId = 0;

    @BeforeEach
    //This is the right one!
    void setUp() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new CharacterDao();
    }

    @Test
    void getAllCharacters() {
        List<Character> characters = dao.getAllCharacters();
        assertEquals(20, characters.size());
    }

    @Test
    void getCharacterByName() {
        List<Character> characters = dao.getCharacterByName("Michael Scott");
        assertEquals(1, characters.size());
    }

        @Test
    void getCharacterByActorName() {
        List<Character> characters = dao.getCharacterByActorName("in");
        assertEquals(7, characters.size());
    }

    @Test
    void createCharacter() {
        int numberOfCharacters = dao.getAllCharacters().size();
        Character newCharacter = new Character();
        newCharacter.setCharacterName("Chair Model");
        newCharacter.setActorName("Brooke Dillman");
        newCharacter.setMemorableQuote("none. She just sits in the chair...");
        dao.createCharacter(newCharacter);
        assertEquals(numberOfCharacters + 1, dao.getAllCharacters().size());
    }

    @Test
    void deleteCharacter() {
        dao.deleteCharacter(dao.getCharacterById(3));
        assertNull(dao.getCharacterById(3));
    }

    @Test
    void updateCharacter() {
        String newCharacterName = "David Brent";
        Character characterToUpdate = dao.getCharacterById(1);
        characterToUpdate.setCharacterName(newCharacterName);
        dao.updateCharacter(characterToUpdate);
        List<Character> updatedCharacter = dao.getCharacterByName(newCharacterName);
        assertEquals(1, updatedCharacter.size());
    }
    
}