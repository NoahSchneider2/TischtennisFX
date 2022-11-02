package com.example.tischtennisfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class mainController {

    @FXML
    private ComboBox<?> Combo1;

    @FXML
    private ComboBox<?> Combo2;

    @FXML
    private Button Tisch1Start;

    @FXML
    private Label Tisch1T1N;

    @FXML
    private Label Tisch1T1NP;

    @FXML
    private Label Tisch1T2N;

    @FXML
    private Label Tisch1T2NP;

    @FXML
    private Button Tisch2Start;

    @FXML
    private Label Tisch2T1N;

    @FXML
    private Label Tisch2T1NP;

    @FXML
    private Label Tisch2T2N;

    @FXML
    private Label Tisch2T2NP;

    @FXML
    private Button addTisch2T2;


    private int tisch1T1P;
    private int tisch1T2P;

    private int tisch2T1P;
    private int tisch2T2P;

    @FXML
    void addTisch1T1(ActionEvent event) {
        ++tisch1T1P;
        Tisch1T1NP.setText(""+tisch1T1P);
    }

    @FXML
    void addTisch1T2(ActionEvent event) {
        ++tisch1T2P;
        Tisch1T2NP.setText(""+tisch1T2P);
    }

    @FXML
    void addTisch2T1(ActionEvent event) {
        ++tisch2T1P;
        Tisch2T1NP.setText(""+tisch2T1P);
    }

    @FXML
    void addTisch2T2(ActionEvent event) {
        ++tisch2T2P;
        Tisch2T2NP.setText(""+tisch2T2P);
    }

    @FXML
    void delTisch1T1(ActionEvent event) {
        --tisch1T1P;
        Tisch1T1NP.setText(""+tisch1T1P);
    }

    @FXML
    void delTisch1T2(ActionEvent event) {
        --tisch1T2P;
        Tisch1T2NP.setText(""+tisch1T2P);
    }

    @FXML
    void delTisch2T1(ActionEvent event) {
        --tisch2T1P;
        Tisch2T1NP.setText(""+tisch2T1P);
    }

    @FXML
    void delTisch2T2(ActionEvent event) {
        --tisch2T2P;
        Tisch2T2NP.setText(""+tisch2T2P);
    }

}

