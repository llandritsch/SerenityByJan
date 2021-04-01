package edu.matc.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Character;
import edu.matc.persistence.CharacterDao;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

// TODO investigate characters that are showing up weird in output

/**
 * The type Character service.
 */
@Log4j2
@Path("/characters")
public class CharacterService {

    // JSON string reference: https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/

    /**
     * Gets all characters.
     *
     * @return all characters
     */
    @GET
    @Produces("application/json")
    public Response getAllCharacters() {
        CharacterDao dao = new CharacterDao();
        List<Character> characters = dao.getAllCharacters();
        String output = formatFoundCharacters(characters);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets by character name.
     *
     * @param name the name
     * @return the by character name
     */
    @GET
    @Produces("application/json")
    @Path("{character}")
    public Response getByCharacterName(@PathParam("character") String name) {
        CharacterDao dao = new CharacterDao();
        List<Character> characters = dao.getCharacterByName(name);
        String output = formatFoundCharacters(characters);

        return Response.status(200).entity(output).build();

    }

    /**
     * Gets by actor name.
     *
     * @param name the name
     * @return the by actor name
     */
    @GET
    @Produces("application/json")
    @Path("/actor/{actor}")
    public Response getByActorName(@PathParam("actor") String name) {
        CharacterDao dao = new CharacterDao();
        List<Character> characters = dao.getCharacterByActorName(name);
        String output = formatFoundCharacters(characters);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public Response getById(@PathParam("id") int id) {
        ObjectMapper mapper = new ObjectMapper();

        CharacterDao dao = new CharacterDao();
        Character character = dao.getCharacterById(id);

        String output = "";

        try {
            output = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(character);
        } catch (JsonProcessingException e){
            log.error(e);
        }

        return Response.status(200).entity(output).build();
    }


    /**
     * Takes a list of characters and formats into a pretty JSON string
     *
     * @param characters list of characters
     * @return JSON formatted string of found characters
     */
    public String formatFoundCharacters(List<Character> characters) {
        ObjectMapper mapper = new ObjectMapper();
        String foundCharacters = "";

        for (Character character : characters) {
            try {
                String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(character);
                foundCharacters += jsonString;
            } catch (JsonProcessingException e){
                log.error(e);
            }
        }
        return foundCharacters;
    }

}
