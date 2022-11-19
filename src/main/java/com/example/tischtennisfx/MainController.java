package com.example.tischtennisfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button addTable2T2;

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
            pointsTeamOneLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamOne());

            teamTwoPlayerNameLeftTable.setText(matchOnLeftTable.getTeamTwo().getName());
            pointsTeamTwoLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamTwo());

            return;
        }
        if(table == "right") {
            matchOnRightTable = match;
            teamOnePlayerNameRightTable.setText(matchOnRightTable.getTeamOne().getName());
            pointsTeamOneRightTable.setText("" + matchOnRightTable.getPointsOfTeamOne());

            teamTwoPlayerNameRightTable.setText(matchOnRightTable.getTeamTwo().getName());
            pointsTeamTwoRightTable.setText("" + matchOnRightTable.getPointsOfTeamTwo());


            return;
        }
        System.out.println("Fehlerhafte Tischnummer");
    }

    public void plusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.addPointToTeamOne();
        updateLabels();
        }

    @FXML
    public void plusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.addPointToTeamTwo();
        updateLabels();
    }
    @FXML
    public void plusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.addPointToTeamOne();
        updateLabels();
    }

    @FXML
    public void plusPointTeamTwoRightTable(ActionEvent event) {
        matchOnRightTable.addPointToTeamTwo();
        updateLabels();
    }

    @FXML
    public void minusPointTeamOneLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamOne();
        updateLabels();
    }

    @FXML
    public void minusPointTeamTwoLeftTable(ActionEvent event) {
        matchOnLeftTable.subPointToTeamTwo();
        updateLabels();
    }

    @FXML
    public void minusPointTeamOneRightTable(ActionEvent event) {
        matchOnRightTable.subPointToTeamOne();
        updateLabels();
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
    private void updateLabels() {
        updateMainLabels();
        updateSpectatorLabels();
    }

    private void updateSpectatorLabels() {
        SpectatorController controller = getScoreController();
    }
    private void updateMainLabels() {
        pointsTeamOneLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamOne());
        pointsTeamOneRightTable.setText("" + matchOnRightTable.getPointsOfTeamOne());
        pointsTeamTwoLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamTwo());
        pointsTeamTwoRightTable.setText("" + matchOnRightTable.getPointsOfTeamTwo());
    }
}

