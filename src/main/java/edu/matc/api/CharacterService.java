package edu.matc.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.bind.v2.TODO;
import edu.matc.entity.Character;
import edu.matc.persistence.CharacterDao;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//// TODO investigate characters that are showing up weird in output

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

    //TODO Test
    @POST
    @Path("/character/{characterName}/{actorName}/{memorableQuote}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createCharacter(@PathParam("characterName") String characterName,
            @PathParam("actorName") String actorName,
            @PathParam("memorableQuote") String memorableQuote
    ) {
        CharacterDao dao = new CharacterDao();
        Character character = new Character();
        character.setCharacterName(characterName);
        character.setActorName(actorName);
        character.setMemorableQuote(memorableQuote);
        int id = dao.createCharacter(character);
        if(id != 0) {
            character.setId(id);
            GenericEntity<Character> myEntity = new GenericEntity<Character>(character) {};
            return Response.status(200).entity(myEntity).build();
        } else {
            return Response.status(500).build();
        }
    }

    //TODO fix response and param type
    @DELETE
    @Path("characters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id) {
        CharacterDao dao = new CharacterDao();
        int charactersBeforeDelete = dao.getAllCharacters().size();
        Character characterToDelete = dao.getCharacterById(id);
        dao.deleteCharacter(characterToDelete);
        int charactersAfterDelete = dao.getAllCharacters().size();
        if (charactersAfterDelete == charactersBeforeDelete - 1) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }

    @PUT
    @Path("/characters")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateCharacter(@PathParam())
}
