package com.example.tischtennisfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SpectatorController {

    @FXML
    private Label leftMatchLabel;
    @FXML
    private Label rightMatchLabel;
    @FXML
    private Label nameOfTeamOne;

    @FXML
    private Label nameOfTeamTwo;

    @FXML
    private Label pointsOfTeamOne;

    @FXML
    private Label pointsOfTeamTwo;

    @FXML
    private Label teamOneTableLeftPlayerOneName;

    @FXML
    private Label teamOneTableLeftPoints;

    @FXML
    private Label teamOneTableLeftPlayerTwoName;

    @FXML
    private Label teamOneTableRightPlayerOneName;

    @FXML
    private Label teamOneTableRightPoints;

    @FXML
    private Label teamOneTableRightPlayerTwoName;

    @FXML
    private Label teamTwoTableLeftPlayerOneName;

    @FXML
    private Label teamTwoTableLeftPoints;

    @FXML
    private Label teamTwoTableLeftPlayerTwoName;

    @FXML
    private Label teamTwoTableRightPlayerOneName;

    @FXML
    private Label teamTwoTableRightPoints;

    @FXML
    private Label teamTwoTableRightPlayerTwoName;

    public Label getNameOfTeamOne() {
        return nameOfTeamOne;
    }

    public Label getNameOfTeamTwo() {
        return nameOfTeamTwo;
    }

    public Label getPointsOfTeamOne() {
        return pointsOfTeamOne;
    }

    public Label getPointsOfTeamTwo() {
        return pointsOfTeamTwo;
    }

    public Label getTeamOneTableLeftPlayerOneName() {
        return teamOneTableLeftPlayerOneName;
    }

    public Label getTeamOneTableLeftPlayerTwoName() {
        return teamOneTableLeftPlayerTwoName;
    }

    public Label getTeamOneTableLeftPoints() {
        return teamOneTableLeftPoints;
    }

    public Label getTeamTwoTableLeftPlayerOneName() {
        return teamTwoTableLeftPlayerOneName;
    }

    public Label getTeamTwoTableLeftPlayerTwoName() {
        return teamTwoTableLeftPlayerTwoName;
    }

    public Label getTeamTwoTableLeftPoints() {
        return teamTwoTableLeftPoints;
    }

    public Label getTeamOneTableRightPlayerOneName() {
        return teamOneTableRightPlayerOneName;
    }

    public Label getTeamOneTableRightPlayerTwoName() {
        return teamOneTableRightPlayerTwoName;
    }

    public Label getTeamOneTableRightPoints() {
        return teamOneTableRightPoints;
    }

    public Label getTeamTwoTableRightPlayerOneName() {
        return teamTwoTableRightPlayerOneName;
    }

    public Label getTeamTwoTableRightPlayerTwoName() {
        return teamTwoTableRightPlayerTwoName;
    }

    public Label getTeamTwoTableRightPoints() {
        return teamTwoTableRightPoints;
    }

    public Label getLeftMatchLabel() {
        return leftMatchLabel;
    }

    public Label getRightMatchLabel() {
        return rightMatchLabel;
    }
}
