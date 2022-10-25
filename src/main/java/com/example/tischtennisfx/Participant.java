package com.example.tischtennisfx;

public class Participant {


    Participant(String spielerName, Team team) {
        setName(spielerName);
        setTeam(team);
    }

    private String name;

    private int doppel;

    private Team team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getDoppel() {
        return doppel;
    }

    public void setDoppel(int doppel) {
        this.doppel = doppel;
    }

    /**
     *  Damit werden die Objekte korrekt in den Frontendelementen angezeigt.
      */

    @Override
    public String toString()  {
        return getName();
    }
}
