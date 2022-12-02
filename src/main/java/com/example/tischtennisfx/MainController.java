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

    public void setScoreController(SpectatorController scoreController) {
        this.scoreController = scoreController;
    }

    public SpectatorController getScoreController() {
        return scoreController;
    }

    private void updateScore() {
        SpectatorController controller = getScoreController();
        if (matchOnLeftTable != null) {
            controller.getTeamOneTableLeftPoints().setText("" + matchOnLeftTable.getPointsOfTeamOne());
            controller.getTeamTwoTableLeftPoints().setText("" + matchOnLeftTable.getPointsOfTeamTwo());
            pointsTeamOneLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamOne());
            pointsTeamTwoLeftTable.setText("" + matchOnLeftTable.getPointsOfTeamTwo());
        }
        if (matchOnRightTable != null) {
            controller.getTeamOneTableRightPoints().setText("" + matchOnRightTable.getPointsOfTeamOne());
            controller.getTeamTwoTableRightPoints().setText("" + matchOnRightTable.getPointsOfTeamTwo());
            pointsTeamOneRightTable.setText("" + matchOnRightTable.getPointsOfTeamOne());
            pointsTeamTwoRightTable.setText("" + matchOnRightTable.getPointsOfTeamTwo());
        }
        controller.getPointsOfTeamOne().setText("" + teamOne.getPoints());
        controller.getPointsOfTeamTwo().setText("" + teamTwo.getPoints());
    }

    private void updateLeftSpectatorLabels() {
        SpectatorController controller = getScoreController();
        controller.getTeamOneTableLeftPlayerOneName().setText("" + matchOnLeftTable.teamOneParticipants.get(0));
        controller.getTeamTwoTableLeftPlayerOneName().setText("" + matchOnLeftTable.teamTwoParticipants.get(0));
        if(matchOnLeftTable.isDoubleMatch()) {
            controller.getTeamOneTableLeftPlayerTwoName().setText("" + matchOnLeftTable.teamOneParticipants.get(1));
            controller.getTeamTwoTableLeftPlayerTwoName().setText("" + matchOnLeftTable.teamOneParticipants.get(1));
        } else {
            controller.getTeamOneTableLeftPlayerTwoName().setText("");
            controller.getTeamTwoTableLeftPlayerTwoName().setText("");
        }
    }

    private void updateRightSpectatorLabels() {
        SpectatorController controller = getScoreController();
        controller.getTeamOneTableRightPlayerOneName().setText("" + matchOnRightTable.teamOneParticipants.get(0));
        controller.getTeamTwoTableRightPlayerOneName().setText("" + matchOnRightTable.teamTwoParticipants.get(0));
        if (matchOnRightTable.isDoubleMatch()) {
            controller.getTeamOneTableRightPlayerTwoName().setText("" + matchOnRightTable.teamOneParticipants.get(1));
            controller.getTeamTwoTableRightPlayerTwoName().setText("" + matchOnRightTable.teamOneParticipants.get(1));
        } else {
            controller.getTeamOneTableRightPlayerTwoName().setText("");
            controller.getTeamTwoTableRightPlayerTwoName().setText("");
        }
    }
}

