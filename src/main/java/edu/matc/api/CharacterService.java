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

@Log4j2
@Path("/characters")
public class CharacterService {

    // JSON string reference: https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/

    @GET
    @Produces("application/json")
    public Response getAllCharacters() {
        CharacterDao dao = new CharacterDao();
        List<Character> characters = dao.getAllCharacters();
        String output = formatFoundCharacters(characters);

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("{character}")
    public Response getByCharacterName(@PathParam("character") String name) {
        CharacterDao dao = new CharacterDao();
        List<Character> characters = dao.getCharacterByName(name);
        String output = formatFoundCharacters(characters);

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
