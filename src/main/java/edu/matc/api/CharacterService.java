package edu.matc.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Character;
import edu.matc.persistence.CharacterDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/characters")
public class CharacterService {

    // JSON string reference: https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/

    @GET
    @Produces("application/json")
    public Response getCharacters() throws JsonProcessingException {
        CharacterDao dao = new CharacterDao();
        List<Character> characters = dao.getAllCharacters();
        ObjectMapper mapper = new ObjectMapper();

        String output = "";

        for (Character character : characters) {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(character);
            output += jsonString;
        }

        return Response.status(200).entity(output).build();

    }
}
