package edu.eci.arsw.petbook.model;

import java.util.List;

public class Company extends User{

    private List<Event> events;

    public Company(){}

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
