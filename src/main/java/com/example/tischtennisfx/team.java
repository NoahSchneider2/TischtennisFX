package com.example.tischtennisfx;

public class team {

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

    public void addOnePoint() {
        this.points++;
    }
}
