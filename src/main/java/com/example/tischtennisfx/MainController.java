package com.example.tischtennisfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class MainController {

    private boolean isWernerScheffler = false;
    @FXML
    private Label leftMatchEnd;

    @FXML
    private Label rightMatchEnd;

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
    public void initializeController() {
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
        if (table == "left") {
            matchOnLeftTable = match;
            matchNumberLabelLeft.setText(matchOnLeftTable.toString());
            updateScore();
            updateLeftSpectatorLabels();
            return;
        }
        if (table == "right") {
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

    @FXML
    public void plusPointTeamOneLeftTable(ActionEvent event) {
        if (matchOnLeftTable.hasWinner()) {
            return;
        }
        matchOnLeftTable.addPointToTeamOne();
        if (matchOnLeftTable.hasEndScoreReached()) {
            matchOnLeftTable.giveWinnerOnePoint();
            leftMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamTwoLeftTable(ActionEvent event) {

        if (matchOnLeftTable.hasWinner()) {
            return;
        }
        matchOnLeftTable.addPointToTeamTwo();
        if (matchOnLeftTable.hasEndScoreReached()) {
            matchOnLeftTable.giveWinnerOnePoint();
            leftMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamOneRightTable(ActionEvent event) {

        if (matchOnRightTable.hasWinner()) {
            return;
        }
        matchOnRightTable.addPointToTeamOne();
        if (matchOnRightTable.hasEndScoreReached()) {
            matchOnRightTable.giveWinnerOnePoint();
            rightMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamTwoRightTable(ActionEvent event) {

        if (matchOnRightTable.hasWinner()) {
            return;
        }
        matchOnRightTable.addPointToTeamTwo();
        if (matchOnRightTable.hasEndScoreReached()) {
            matchOnRightTable.giveWinnerOnePoint();
            rightMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void minusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamOne();
        if (matchOnLeftTable.isScoreNegative()) {
            matchOnLeftTable.addPointToTeamOne();
        }
        leftMatchEnd.setText("");
        matchOnLeftTable.setbackWinnerIfNeeded();
        updateScore();
    }

    @FXML
    public void minusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamTwo();
        if (matchOnLeftTable.isScoreNegative()) {
            matchOnLeftTable.addPointToTeamTwo();
        }
        leftMatchEnd.setText("");
        matchOnLeftTable.setbackWinnerIfNeeded();
        updateScore();
    }

    @FXML
    public void minusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamOne();
        if (matchOnRightTable.isScoreNegative()) {
            matchOnRightTable.addPointToTeamOne();
        }
        matchOnRightTable.setbackWinnerIfNeeded();
        rightMatchEnd.setText("");
        updateScore();
    }

    @FXML
    public void minusPointTeamTwoRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamTwo();
        if (matchOnRightTable.isScoreNegative()) {
            matchOnRightTable.addPointToTeamTwo();
        }
        matchOnRightTable.setbackWinnerIfNeeded();
        rightMatchEnd.setText("");
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
            spectatorController.getTeamOneTableLeftPoints().setText(String.valueOf(matchOnLeftTable.getPointsOfTeamOne()));
            spectatorController.getTeamTwoTableLeftPoints().setText(String.valueOf(matchOnLeftTable.getPointsOfTeamTwo()));
            pointsTeamOneLeftTable.setText(String.valueOf(matchOnLeftTable.getPointsOfTeamOne()));
            pointsTeamTwoLeftTable.setText(String.valueOf(matchOnLeftTable.getPointsOfTeamTwo()));
            if(matchOnLeftTable.hasWinner()){
                leftMatchEnd.setText("Match ist beendet");
            } else {
                leftMatchEnd.setText("");
            }
        }
        if (matchOnRightTable != null) {
            spectatorController.getTeamOneTableRightPoints().setText(String.valueOf(matchOnRightTable.getPointsOfTeamOne()));
            spectatorController.getTeamTwoTableRightPoints().setText(String.valueOf(matchOnRightTable.getPointsOfTeamTwo()));
            pointsTeamOneRightTable.setText(String.valueOf(matchOnRightTable.getPointsOfTeamOne()));
            pointsTeamTwoRightTable.setText(String.valueOf(matchOnRightTable.getPointsOfTeamTwo()));
            if(matchOnRightTable.hasWinner()){
                rightMatchEnd.setText("Match ist beendet");
            } else {
                rightMatchEnd.setText("");
            }
        }
        spectatorController.getPointsOfTeamOne().setText(String.valueOf(teamOne.getPoints()));
        spectatorController.getPointsOfTeamTwo().setText(String.valueOf(teamTwo.getPoints()));
        if (endOfWernerScheffler()) {
            leftMatchEnd.setText("Team " + getWinningTeamName() + " hat ");
            rightMatchEnd.setText("das Spiel gewonnen!!");
        }
    }

    private void updateLeftSpectatorLabels() {
        spectatorController.getLeftMatchLabel().setText(matchOnLeftTable.toString());
        spectatorController.getTeamOneTableLeftPlayerOneName().setText(String.valueOf(matchOnLeftTable.teamOneParticipants.get(0)));
        spectatorController.getTeamTwoTableLeftPlayerOneName().setText(String.valueOf(matchOnLeftTable.teamTwoParticipants.get(0)));
        if (matchOnLeftTable.isDoubleMatch()) {
            spectatorController.getTeamOneTableLeftPlayerTwoName().setText(String.valueOf(matchOnLeftTable.teamOneParticipants.get(1)));
            spectatorController.getTeamTwoTableLeftPlayerTwoName().setText(String.valueOf(matchOnLeftTable.teamTwoParticipants.get(1)));
        } else {
            spectatorController.getTeamOneTableLeftPlayerTwoName().setText("");
            spectatorController.getTeamTwoTableLeftPlayerTwoName().setText("");
        }
    }

    private void updateRightSpectatorLabels() {
        spectatorController.getRightMatchLabel().setText(matchOnRightTable.toString());
        spectatorController.getTeamOneTableRightPlayerOneName().setText(String.valueOf(matchOnRightTable.teamOneParticipants.get(0)));
        spectatorController.getTeamTwoTableRightPlayerOneName().setText(String.valueOf(matchOnRightTable.teamTwoParticipants.get(0)));
        if (matchOnRightTable.isDoubleMatch()) {
            spectatorController.getTeamOneTableRightPlayerTwoName().setText(String.valueOf(matchOnRightTable.teamOneParticipants.get(1)));
            spectatorController.getTeamTwoTableRightPlayerTwoName().setText(String.valueOf(matchOnRightTable.teamTwoParticipants.get(1)));
        } else {
            spectatorController.getTeamOneTableRightPlayerTwoName().setText("");
            spectatorController.getTeamTwoTableRightPlayerTwoName().setText("");
        }
    }
    private boolean endOfWernerScheffler() {
        return (teamOne.getPoints() == 8 || teamTwo.getPoints() == 8) && isWernerScheffler();
    }

    private String getWinningTeamName() {
        if(teamOne.getPoints() == teamTwo.getPoints()){
            return "";
        }
        if(teamOne.getPoints() > teamTwo.getPoints()) {
            return teamOne.getName();
        }
        return teamTwo.getName();
    }

    public boolean isWernerScheffler() {
        return isWernerScheffler;
    }

    public void setWernerScheffler(boolean wernerScheffler) {
        isWernerScheffler = wernerScheffler;
    }
}

