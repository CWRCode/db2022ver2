package se.iths;

import java.util.HashMap;
import java.util.Map;

public class Artist {

    private final Long id;
    private String name;

    private Map<Long, Album> albums = new HashMap<>();

    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Album album) {
        albums.put(album.getId(), album);
    }

    @Override
    public String toString() {
        return id + " - " + name + " has (" + albums.size() + ") albums";
    }
}
