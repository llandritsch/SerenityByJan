package edu.matc.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//TODO optional: change path name from service to something else?
@ApplicationPath("/service")

public class CharacterApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(CharacterService.class);
        return h;
    }
}