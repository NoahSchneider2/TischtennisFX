package com.example.tischtennisfx;

public class Participant {


    Participant(String spielerName, String teamName) {
        setName(spielerName);
        setTeam(teamName);
    }

    private String name;

    private String position;

    private int doppel;

    private String team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getDoppel() {
        return doppel;
    }

    public void setDoppel(int doppel) {
        this.doppel = doppel;
    }
}
