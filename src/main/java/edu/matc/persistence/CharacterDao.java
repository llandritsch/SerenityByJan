package edu.matc.persistence;

import edu.matc.entity.Character;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

@Log4j2
public class CharacterDao {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all characters
     * 
     * @return all the characters
     */
    public List<Character> getAllCharacters() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Character> query = builder.createQuery(Character.class);
        Root<Character> root = query.from(Character.class);
        List<Character> characters = session.createQuery(query).getResultList();

        session.close();
        return characters;
    }

    /**
     * Gets a character by character name
     * @param character_name
     * @return characters by name
     */
    public List<Character> getCharacterByName(String character_name) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Character> query = builder.createQuery(Character.class);
        Root<Character> root = query.from(Character.class);
        Expression<String> propertyPath = root.get("character_name");
        query.where(builder.like(propertyPath, "%" + character_name + "%"));
        List<Character> characters = session.createQuery(query).getResultList();
        session.close();
        return characters;
    }

    /**
     * Gets a character by Id
     * @param ID
     * @return character
     */
    public Character getCharacterById(int ID) {
        Session session = sessionFactory.openSession();
        Character character = session.get(Character.class, ID);
        session.close();
        return character;
    }

}
