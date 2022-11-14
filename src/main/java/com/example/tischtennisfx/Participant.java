package com.example.tischtennisfx;

public class Participant {

    private int position;
    private String name;

    private int doubleUnit;

    private Team team;
    Participant(String spielerName, Team team, int position) {
        setName(spielerName);
        setTeam(team);
        setPosition(position);
    }

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

    public int getDouble() {
        return doubleUnit;
    }

    public void setDouble(int doubleUnit) {
        this.doubleUnit = doubleUnit;
    }

    /**
     *  Damit werden die Objekte korrekt in den Frontendelementen angezeigt.
      */

    @Override
    public String toString()  {
        return getName();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
