package com.example.tischtennisfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class mainController {

    @FXML
    private Label t1;

    @FXML
    void buAc(ActionEvent event) {
        t1.setText("bubuubuub");
    }

}
