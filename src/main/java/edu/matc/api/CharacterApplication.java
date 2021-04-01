package edu.matc.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//TODO optional: Since only purpose is an API I am not including a path but we can change it!
@ApplicationPath("/")

public class CharacterApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(CharacterService.class);
        return h;
    }
}