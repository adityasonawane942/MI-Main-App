package com.example.miapp.Retrofit;

public class Event {
    private String genre;
    private String event_name;
    private String event_desc;
    private String event_venue;
    private String event_date;
    private String event_time;

    public Event(String genre,String event_name, String event_desc, String event_venue, String event_date, String event_time) {
        this.genre=genre;
        this.event_name = event_name;
        this.event_desc = event_desc;
        this.event_venue = event_venue;
        this.event_date = event_date;
        this.event_time = event_time;
    }

    public String getEvent_name(){return event_name;}
    public String getEvent_desc(){return event_desc;}
    public String getGenre(){return genre;}
    public String getEvent_venue() {
        return event_venue;
    }

    public String getEvent_date() {
        return event_date;
    }

    public String getEvent_time() {
        return event_time;
    }
}
