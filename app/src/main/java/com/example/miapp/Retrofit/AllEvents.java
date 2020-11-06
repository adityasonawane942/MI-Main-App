package com.example.miapp.Retrofit;

import java.util.List;

public class AllEvents {
    private String genre_name;
    private List<Event> event;

    public AllEvents(String genre_name, List<Event> event) {
        this.genre_name = genre_name;
        this.event = event;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public List<Event> getEvent() {
        return event;
    }
}
