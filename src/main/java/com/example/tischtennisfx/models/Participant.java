package com.example.tischtennisfx.models;

public class Participant {

    public Team team;
    public String name;
    public int doubleUnit;
    public Participant(String spielerName, Team team) {
        this.name = spielerName;
        this.team = team;
    }

    /**
     * Damit werden die Objekte korrekt in den Frontendelementen angezeigt.
     */
    @Override
    public String toString() {
        return this.name;
    }
}