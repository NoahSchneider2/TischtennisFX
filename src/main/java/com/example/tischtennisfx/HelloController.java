package com.example.tischtennisfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList; // Package for the ArrayList
import javafx.collections.ObservableList; // Package for the ObservableList
import javafx.collections.FXCollections;

public class HelloController {

    private ArrayList<String> membersOfTeamOne = new ArrayList<>();
    private ArrayList<String> membersOfTeamTwo = new ArrayList<>();

    private ArrayList<String> d1t1List = new ArrayList<>();
    private ArrayList<String> d1t2List = new ArrayList<>();
    private String nameOfTeamOne;
    private String nameOfTeamTwo;


    @FXML
    private TextField T1S1N;

    @FXML
    private TextField T1S2N;

    @FXML
    private TextField T1S3N;

    @FXML
    private TextField T1S4N;

    @FXML
    private TextField T2S1N;

    @FXML
    private TextField T2S2N;

    @FXML
    private TextField T2S3N;

    @FXML
    private TextField T2S4N;

    @FXML
    private TextField t1N;

    @FXML
    private ChoiceBox<?> t1d1;

    @FXML
    private ChoiceBox<?> t1d2;

    @FXML
    private ChoiceBox<?> t2d2;

    @FXML
    private TextField t2N;

    @FXML
    private ChoiceBox<?> t2d1;

    @FXML
    void doppelButton(ActionEvent event) {
        nameOfTeamOne = t1N.getText();
        nameOfTeamTwo = t2N.getText();

        membersOfTeamOne.add(T1S1N.getText());
        membersOfTeamOne.add(T1S2N.getText());
        membersOfTeamOne.add(T1S3N.getText());
        membersOfTeamOne.add(T1S4N.getText());

        membersOfTeamTwo.add(T2S1N.getText());
        membersOfTeamTwo.add(T2S2N.getText());
        membersOfTeamTwo.add(T2S3N.getText());
        membersOfTeamTwo.add(T2S4N.getText());

        ObservableList t1nOb = FXCollections.observableList(membersOfTeamOne);
        ObservableList t2nOb = FXCollections.observableList(membersOfTeamTwo);
        t1d1.setItems(t1nOb);
        t1d2.setItems(t1nOb);
        t2d1.setItems(t2nOb);
        t2d2.setItems(t2nOb);
    }

    @FXML
    void tunierstartButton(ActionEvent event) {
        d1t1List.add(t1d1.getValue().toString());
        d1t1List.add(t1d2.getValue().toString());

        d1t2List.add(t2d1.getValue().toString());
        d1t2List.add(t2d2.getValue().toString());
    }
}
