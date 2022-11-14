package com.example.tischtennisfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class MainController {

    private Team teamOne;

    private Team teamTwo;

    private ArrayList<Match> matches = new ArrayList<Match>();
    @FXML
    private ComboBox<?> Combo1;

    @FXML
    private ComboBox<?> Combo2;

    private Match matchOnTableOne;

    private Match matchOnTableTwo;
    @FXML
    private Button Table1Start;

    @FXML
    private Label Table1T1N;

    @FXML
    private Label Table1T1NP;

    @FXML
    private Label Table1T2N;

    @FXML
    private Label Table1T2NP;

    @FXML
    private Button Table2Start;

    @FXML
    private Label Table2T1N;

    @FXML
    private Label Table2T1NP;

    @FXML
    private Label Table2T2N;

    @FXML
    private Label Table2T2NP;

    @FXML
    private Button addTable2T2;

    @FXML
    public void initalizeController()
    {
        //TODO Dropdowns und Labels befüllen
    }

    void addTable1T1(ActionEvent event) {
        ++tisch1T1P;
        Table1T1NP.setText(""+tisch1T1P);
    }

    @FXML
    void addTable1T2(ActionEvent event) {
        ++tisch1T2P;
        Table1T2NP.setText(""+tisch1T2P);
    }
    @FXML
    void addTable2T1(ActionEvent event) {
        ++tisch2T1P;
        Table2T1NP.setText(""+tisch2T1P);
    }

    @FXML
    void addTable2T2(ActionEvent event) {
        ++tisch2T2P;
        Table2T2NP.setText(""+tisch2T2P);
    }

    @FXML
    void delTable1T1(ActionEvent event) {
        --tisch1T1P;
        Table1T1NP.setText(""+tisch1T1P);
    }

    @FXML
    void delTable1T2(ActionEvent event) {
        --tisch1T2P;
        Table1T2NP.setText(""+tisch1T2P);
    }

    @FXML
    void delTable2T1(ActionEvent event) {
        --tisch2T1P;
        Table2T1NP.setText(""+tisch2T1P);
    }

    @FXML
    void delTable2T2(ActionEvent event) {
        --tisch2T2P;
        Table2T2NP.setText(""+tisch2T2P);
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }
}

