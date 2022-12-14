package com.example.tischtennisfx;

public class Team {

    Team(String teamName) {
        setName(teamName);
    }

    private String name;

    private int points = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void addWonMatch() {
        this.points++;
    }

    public void subWonMatch() {
        this.points--;
    }
}
