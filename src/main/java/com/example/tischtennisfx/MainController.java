package com.example.tischtennisfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class MainController {

    private SpectatorController scoreController;

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
    private Label teamOnePlayerNameLeftTable;

    @FXML
    private Label pointsTeamOneLeftTable;

    @FXML
    private Label teamTwoPlayerNameLeftTable;

    @FXML
    private Label pointsTeamTwoLeftTable;
    @FXML
    private Label teamOnePlayerNameRightTable;

    @FXML
    private Label pointsTeamOneRightTable;

    @FXML
    private Label teamTwoPlayerNameRightTable;

    @FXML
    private Label pointsTeamTwoRightTable;

    @FXML
    private Label MatchNumberLabelLeft;

    @FXML
    private Label MatchNumberLabelRight;

    public MainController() {
    }

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
            teamOnePlayerNameLeftTable.setText(matchOnLeftTable.getTeamOne().getName());
            updateScoreLabels();
            updateLeftSpectatorTeamLabels();

            return;
        }
        if(table == "right") {
            matchOnRightTable = match;
            teamOnePlayerNameRightTable.setText(matchOnRightTable.getTeamOne().getName());
            updateScoreLabels();
            updateRightSpectatorTeamLabels();

            return;
        }
        System.out.println("Fehlerhafte Tischnummer");
    }

    public void plusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.addPointToTeamOne();
        updateScoreLabels();
        }

    @FXML
    public void plusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.addPointToTeamTwo();
        updateScoreLabels();
    }
    @FXML
    public void plusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.addPointToTeamOne();
        updateScoreLabels();
    }

    @FXML
    public void plusPointTeamTwoRightTable(ActionEvent event) {
        matchOnRightTable.addPointToTeamTwo();
        updateScoreLabels();
    }

    @FXML
    public void minusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamOne();
        updateScoreLabels();
    }

    @FXML
    public void minusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamTwo();
        updateScoreLabels();
    }

    @FXML
    public void minusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamOne();
        updateScoreLabels();
    }
    public void minusPointTeamTwoRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamTwo();
        updateScoreLabels();
    }

    @FXML
    public void delTable2T2(ActionEvent event) {
        matchOnRightTable.subPointToTeamTwo();
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

    public void setScoreController(SpectatorController scoreController) {
        this.scoreController = scoreController;
    }

    public SpectatorController getScoreController() {
        return scoreController;
    }
    private void updateScoreLabels() {
        updateMainScoreLabels();
        updateSpectatorScoreLabels();
    }
    private void updateMainScoreLabels() {
        if (matchOnLeftTable != null) {
            pointsTeamOneLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamOne());
            pointsTeamTwoLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamTwo());
        }
        if(matchOnRightTable != null) {
            pointsTeamOneRightTable.setText("" + matchOnRightTable.getPointsOfTeamOne());
            pointsTeamTwoRightTable.setText("" + matchOnRightTable.getPointsOfTeamTwo());
        }
    }
    private void updateSpectatorScoreLabels() {
        SpectatorController controller = getScoreController();
        if (matchOnLeftTable != null) {
            controller.getTeamOneTableLeftPoints().setText("" + matchOnLeftTable.getPointsOfTeamOne());
            controller.getTeamTwoTableLeftPoints().setText("" + matchOnLeftTable.getPointsOfTeamTwo());
        }
        if (matchOnRightTable != null) {
            controller.getTeamOneTableRightPoints().setText("" + matchOnRightTable.getPointsOfTeamOne());
            controller.getTeamTwoTableRightPoints().setText("" + matchOnRightTable.getPointsOfTeamTwo());
        }
    }
    private void updateLeftSpectatorTeamLabels() {
        SpectatorController controller = getScoreController();
        controller.getTeamOneTableLeftPlayerOneName().setText("" + matchOnLeftTable.teamOneParticipants.get(0));
        controller.getTeamTwoTableLeftPlayerOneName().setText("" + matchOnLeftTable.teamTwoParticipants.get(0));
        if(matchOnLeftTable.isDoubleMatch()) {
            controller.getTeamOneTableLeftPlayerTwoName().setText("" + matchOnLeftTable.teamOneParticipants.get(1));
            controller.getTeamTwoTableLeftPlayerTwoName().setText("" + matchOnLeftTable.teamOneParticipants.get(1));
        }
    }
    private void updateRightSpectatorTeamLabels() {
        SpectatorController controller = getScoreController();
        controller.getTeamOneTableRightPlayerOneName().setText("" + matchOnRightTable.teamOneParticipants.get(0));
        controller.getTeamTwoTableRightPlayerOneName().setText("" + matchOnRightTable.teamTwoParticipants.get(0));
        if (matchOnRightTable.isDoubleMatch()) {
            controller.getTeamOneTableRightPlayerTwoName().setText("" + matchOnRightTable.teamOneParticipants.get(1));
            controller.getTeamTwoTableRightPlayerTwoName().setText("" + matchOnRightTable.teamOneParticipants.get(1));
        }
    }
}

