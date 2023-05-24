package com.example.tischtennisfx.models;

import java.util.ArrayList;

public class Team {

    public String name;
    public ArrayList<Participant> participants;

    private int wonMatches = 0;

    public Team(String teamName) {
        name = teamName;
    }
    public int getWonMatches() {
        return wonMatches;
    }

    public void addWonMatch() {
        this.wonMatches++;
    }

    public void removeWonMatch() {
        this.wonMatches--;
    }
}
