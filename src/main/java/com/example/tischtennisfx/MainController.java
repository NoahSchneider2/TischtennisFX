package com.example.tischtennisfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class MainController {

    private SpectatorController spectatorController;

    private Team teamOne;

    private Team teamTwo;

    private ArrayList<Match> matches = new ArrayList<Match>();
    @FXML
    private ComboBox<Match> dropdownMenuLeft;

    @FXML
    private ComboBox<Match> dropdownMenuRight;

    private Match matchOnLeftTable;

    private Match matchOnRightTable;

    @FXML
    private Label teamOneNameLeftTable;

    @FXML
    private Label pointsTeamOneLeftTable;

    @FXML
    private Label teamTwoNameLeftTable;

    @FXML
    private Label pointsTeamTwoLeftTable;

    @FXML
    private Label teamOneNameRightTable;

    @FXML
    private Label pointsTeamOneRightTable;

    @FXML
    private Label teamTwoNameRightTable;

    @FXML
    private Label pointsTeamTwoRightTable;

    @FXML
    private Label matchNumberLabelLeft;

    @FXML
    private Label matchNumberLabelRight;

    @FXML
    public void initializeController()
    {
        ObservableList<Match> matchesForDropdown = FXCollections.observableList(matches);
        this.dropdownMenuLeft.setItems(matchesForDropdown);
        this.dropdownMenuRight.setItems(matchesForDropdown);

    }
    public void startMatchForLeftTable(ActionEvent event) {
        Match match = dropdownMenuLeft.getValue();
        chooseActiveMatch(match, "left");
    }
    public void startMatchForRightTable(ActionEvent event) {
        Match match = dropdownMenuRight.getValue();
        chooseActiveMatch(match, "right");
    }
    
    private void chooseActiveMatch(Match match, String table) {
        if(table == "left"){
            matchOnLeftTable = match;
            matchNumberLabelLeft.setText(matchOnLeftTable.toString());
            updateScore();
            updateLeftSpectatorLabels();
            return;
        }
        if(table == "right") {
            matchOnRightTable = match;
            matchNumberLabelRight.setText(matchOnRightTable.toString());
            updateScore();
            updateRightSpectatorLabels();
            return;
        }
        System.out.println("Fehlerhafte Tischnummer"); //TODO dafür brauch ich noch ein Feld für Infos @Noah
    }
    public void setupMainTeamLabels() {
        teamOneNameLeftTable.setText(teamOne.getName());
        teamTwoNameLeftTable.setText(teamTwo.getName());
        teamOneNameRightTable.setText(teamOne.getName());
        teamTwoNameRightTable.setText(teamTwo.getName());
    }
    public void plusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.addPointToTeamOne();
        if(matchOnLeftTable.isOver()) {
            matchOnLeftTable.giveWinnerOnePoint();
        }
        updateScore();
        }

    @FXML
    public void plusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.addPointToTeamTwo();
        if(matchOnLeftTable.isOver()) {
            matchOnLeftTable.giveWinnerOnePoint();
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.addPointToTeamOne();
        if(matchOnLeftTable.isOver()) {
            matchOnLeftTable.giveWinnerOnePoint();
        };
        updateScore();
    }

    @FXML
    public void plusPointTeamTwoRightTable(ActionEvent event) {
        matchOnRightTable.addPointToTeamTwo();
        if(matchOnLeftTable.isOver()) {
            matchOnLeftTable.giveWinnerOnePoint();
        };
        updateScore();
    }

    @FXML
    public void minusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamOne();
        matchOnLeftTable.setbackWinnerIfNeeded();
        updateScore();
    }

    @FXML
    public void minusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamTwo();
        matchOnLeftTable.setbackWinnerIfNeeded();
        updateScore();
    }

    @FXML
    public void minusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamOne();
        matchOnLeftTable.setbackWinnerIfNeeded();
        updateScore();
    }

    public void minusPointTeamTwoRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamTwo();
        matchOnLeftTable.setbackWinnerIfNeeded();
        updateScore();
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public void setSpectatorController(SpectatorController spectatorController) {
        this.spectatorController = spectatorController;
    }

    private void updateScore() {
        if (matchOnLeftTable != null) {
            spectatorController.getTeamOneTableLeftPoints().setText("" + matchOnLeftTable.getPointsOfTeamOne());
            spectatorController.getTeamTwoTableLeftPoints().setText("" + matchOnLeftTable.getPointsOfTeamTwo());
            pointsTeamOneLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamOne());
            pointsTeamTwoLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamTwo());
        }
        if (matchOnRightTable != null) {
            spectatorController.getTeamOneTableRightPoints().setText("" + matchOnRightTable.getPointsOfTeamOne());
            spectatorController.getTeamTwoTableRightPoints().setText("" + matchOnRightTable.getPointsOfTeamTwo());
            pointsTeamOneRightTable.setText("" + matchOnRightTable.getPointsOfTeamOne());
            pointsTeamTwoRightTable.setText("" + matchOnRightTable.getPointsOfTeamTwo());
        }
        spectatorController.getPointsOfTeamOne().setText("" + teamOne.getPoints());
        spectatorController.getPointsOfTeamTwo().setText("" + teamTwo.getPoints());
    }

    private void updateLeftSpectatorLabels() {
        spectatorController.getTeamOneTableLeftPlayerOneName().setText("" + matchOnLeftTable.teamOneParticipants.get(0));
        spectatorController.getTeamTwoTableLeftPlayerOneName().setText("" + matchOnLeftTable.teamTwoParticipants.get(0));
        if(matchOnLeftTable.isDoubleMatch()) {
            spectatorController.getTeamOneTableLeftPlayerTwoName().setText("" + matchOnLeftTable.teamOneParticipants.get(1));
            spectatorController.getTeamTwoTableLeftPlayerTwoName().setText("" + matchOnLeftTable.teamOneParticipants.get(1));
        } else {
            spectatorController.getTeamOneTableLeftPlayerTwoName().setText("");
            spectatorController.getTeamTwoTableLeftPlayerTwoName().setText("");
        }
    }

    private void updateRightSpectatorLabels() {
        spectatorController.getTeamOneTableRightPlayerOneName().setText("" + matchOnRightTable.teamOneParticipants.get(0));
        spectatorController.getTeamTwoTableRightPlayerOneName().setText("" + matchOnRightTable.teamTwoParticipants.get(0));
        if (matchOnRightTable.isDoubleMatch()) {
            spectatorController.getTeamOneTableRightPlayerTwoName().setText("" + matchOnRightTable.teamOneParticipants.get(1));
            spectatorController.getTeamTwoTableRightPlayerTwoName().setText("" + matchOnRightTable.teamOneParticipants.get(1));
        } else {
            spectatorController.getTeamOneTableRightPlayerTwoName().setText("");
            spectatorController.getTeamTwoTableRightPlayerTwoName().setText("");
        }
    }
}

