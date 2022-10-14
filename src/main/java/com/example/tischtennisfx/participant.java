package com.example.tischtennisfx;

public class participant {


    participant(String spielerName) {
        setName(spielerName);
    }

    private String name;

    private String position;

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
}
