package com.example.tischtennisfx.controller;

import com.example.tischtennisfx.models.Match;
import com.example.tischtennisfx.models.Team;
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

    private ArrayList<Match> matches = new ArrayList<>();
    @FXML
    private ComboBox<Match> dropdownMenuLeft;

    @FXML
    private ComboBox<Match> dropdownMenuRight;

    private Match leftTableMatch;

    private Match rightTableMatch;

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
        switch (table) {
            case "left" -> {
                leftTableMatch = match;
                matchNumberLabelLeft.setText(leftTableMatch.toString());
                updateScore();
                updateLeftSpectatorLabels();
            }
            case "right" -> {
                rightTableMatch = match;
                matchNumberLabelRight.setText(rightTableMatch.toString());
                updateScore();
                updateRightSpectatorLabels();
            }
            default ->
                    System.out.println("Fehlerhafte Tischnummer"); //TODO dafür brauch ich noch ein Feld für Infos @Noah
        }
    }

    public void setupMainTeamLabels() {
        teamOneNameLeftTable.setText(teamOne.name);
        teamTwoNameLeftTable.setText(teamTwo.name);
        teamOneNameRightTable.setText(teamOne.name);
        teamTwoNameRightTable.setText(teamTwo.name);
    }

    @FXML
    public void plusPointTeamOneLeftTableButton(ActionEvent event) {
        if (leftTableMatch.hasWinner()) {
            return;
        }
        leftTableMatch.addPointToTeamOne();
        if (leftTableMatch.hasEndScoreReached()) {
            leftTableMatch.giveWinnerOnePoint();
            leftMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamTwoLeftTableButton(ActionEvent event) {

        if (leftTableMatch.hasWinner()) {
            return;
        }
        leftTableMatch.addPointToTeamTwo();
        if (leftTableMatch.hasEndScoreReached()) {
            leftTableMatch.giveWinnerOnePoint();
            leftMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamOneRightTableButton(ActionEvent event) {

        if (rightTableMatch.hasWinner()) {
            return;
        }
        rightTableMatch.addPointToTeamOne();
        if (rightTableMatch.hasEndScoreReached()) {
            rightTableMatch.giveWinnerOnePoint();
            rightMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void plusPointTeamTwoRightTableButton(ActionEvent event) {

        if (rightTableMatch.hasWinner()) {
            return;
        }
        rightTableMatch.addPointToTeamTwo();
        if (rightTableMatch.hasEndScoreReached()) {
            rightTableMatch.giveWinnerOnePoint();
            rightMatchEnd.setText("Match beendet");
        }
        updateScore();
    }

    @FXML
    public void minusPointTeamOneLeftTableButton(ActionEvent event) {
        leftTableMatch.subPointToTeamOne();
        if (leftTableMatch.isScoreNegative()) {
            leftTableMatch.addPointToTeamOne();
        }
        leftMatchEnd.setText("");
        leftTableMatch.setBackWinnerIfNeeded();
        updateScore();
    }

    @FXML
    public void minusPointTeamTwoLeftTableButton(ActionEvent event) {
        leftTableMatch.subPointToTeamTwo();
        if (leftTableMatch.isScoreNegative()) {
            leftTableMatch.addPointToTeamTwo();
        }
        leftMatchEnd.setText("");
        leftTableMatch.setBackWinnerIfNeeded();
        updateScore();
    }

    @FXML
    public void minusPointTeamOneRightTableButton(ActionEvent event) {
        rightTableMatch.subPointToTeamOne();
        if (rightTableMatch.isScoreNegative()) {
            rightTableMatch.addPointToTeamOne();
        }
        rightTableMatch.setBackWinnerIfNeeded();
        rightMatchEnd.setText("");
        updateScore();
    }

    @FXML
    public void minusPointTeamTwoRightTableButton(ActionEvent event) {
        rightTableMatch.subPointToTeamTwo();
        if (rightTableMatch.isScoreNegative()) {
            rightTableMatch.addPointToTeamTwo();
        }
        rightTableMatch.setBackWinnerIfNeeded();
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
        if (leftTableMatch != null) {
            spectatorController.getTeamOneTableLeftPoints().setText(String.valueOf(leftTableMatch.getPointsOfTeamOne()));
            spectatorController.getTeamTwoTableLeftPoints().setText(String.valueOf(leftTableMatch.getPointsOfTeamTwo()));
            pointsTeamOneLeftTable.setText(String.valueOf(leftTableMatch.getPointsOfTeamOne()));
            pointsTeamTwoLeftTable.setText(String.valueOf(leftTableMatch.getPointsOfTeamTwo()));
            if (leftTableMatch.hasWinner()) {
                leftMatchEnd.setText("Match ist beendet");
            } else {
                leftMatchEnd.setText("");
            }
        }
        if (rightTableMatch != null) {
            spectatorController.getTeamOneTableRightPoints().setText(String.valueOf(rightTableMatch.getPointsOfTeamOne()));
            spectatorController.getTeamTwoTableRightPoints().setText(String.valueOf(rightTableMatch.getPointsOfTeamTwo()));
            pointsTeamOneRightTable.setText(String.valueOf(rightTableMatch.getPointsOfTeamOne()));
            pointsTeamTwoRightTable.setText(String.valueOf(rightTableMatch.getPointsOfTeamTwo()));
            if (rightTableMatch.hasWinner()) {
                rightMatchEnd.setText("Match ist beendet");
            } else {
                rightMatchEnd.setText("");
            }
        }
        spectatorController.getPointsOfTeamOne().setText(String.valueOf(teamOne.getWonMatches()));
        spectatorController.getPointsOfTeamTwo().setText(String.valueOf(teamTwo.getWonMatches()));
        if (endOfWernerScheffler()) {
            leftMatchEnd.setText("Team " + getWinningTeamName() + " hat ");
            rightMatchEnd.setText("das Spiel gewonnen!!");
        }
    }

    private void updateLeftSpectatorLabels() {
        spectatorController.getLeftMatchLabel().setText(leftTableMatch.toString());
        spectatorController.getTeamOneTableLeftPlayerOneName().setText(String.valueOf(leftTableMatch.teamOneParticipants.get(0)));
        spectatorController.getTeamTwoTableLeftPlayerOneName().setText(String.valueOf(leftTableMatch.teamTwoParticipants.get(0)));
        if (leftTableMatch.isDoubleMatch()) {
            spectatorController.getTeamOneTableLeftPlayerTwoName().setText(String.valueOf(leftTableMatch.teamOneParticipants.get(1)));
            spectatorController.getTeamTwoTableLeftPlayerTwoName().setText(String.valueOf(leftTableMatch.teamTwoParticipants.get(1)));
        } else {
            spectatorController.getTeamOneTableLeftPlayerTwoName().setText("");
            spectatorController.getTeamTwoTableLeftPlayerTwoName().setText("");
        }
    }

    private void updateRightSpectatorLabels() {
        spectatorController.getRightMatchLabel().setText(rightTableMatch.toString());
        spectatorController.getTeamOneTableRightPlayerOneName().setText(String.valueOf(rightTableMatch.teamOneParticipants.get(0)));
        spectatorController.getTeamTwoTableRightPlayerOneName().setText(String.valueOf(rightTableMatch.teamTwoParticipants.get(0)));
        if (rightTableMatch.isDoubleMatch()) {
            spectatorController.getTeamOneTableRightPlayerTwoName().setText(String.valueOf(rightTableMatch.teamOneParticipants.get(1)));
            spectatorController.getTeamTwoTableRightPlayerTwoName().setText(String.valueOf(rightTableMatch.teamTwoParticipants.get(1)));
        } else {
            spectatorController.getTeamOneTableRightPlayerTwoName().setText("");
            spectatorController.getTeamTwoTableRightPlayerTwoName().setText("");
        }
    }

    private boolean endOfWernerScheffler() {
        return (teamOne.getWonMatches() == 8 || teamTwo.getWonMatches() == 8) && isWernerScheffler();
    }

    private String getWinningTeamName() {
        if (teamOne.getWonMatches() == teamTwo.getWonMatches()) {
            return "";
        }
        if (teamOne.getWonMatches() > teamTwo.getWonMatches()) {
            return teamOne.name;
        }
        return teamTwo.name;
    }

    public boolean isWernerScheffler() {
        return isWernerScheffler;
    }

    public void setWernerScheffler(boolean wernerScheffler) {
        isWernerScheffler = wernerScheffler;
    }
}

