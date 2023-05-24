package com.example.tischtennisfx.controller;

import com.example.tischtennisfx.Main;
import com.example.tischtennisfx.factory.MatchFactory;
import com.example.tischtennisfx.models.Match;
import com.example.tischtennisfx.models.Participant;
import com.example.tischtennisfx.models.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SetupController {
    private Team teamOne;
    private Team teamTwo;
    private final ArrayList<Match> matches = new ArrayList<Match>();
    private final MatchFactory matchFactory = new MatchFactory();
    private Stage stageOne;


    @FXML
    private Label errorLabel;
    @FXML
    private Label teamOneLabel;

    @FXML
    private Label teamTwoLabel;
    @FXML
    private TextField nameOfParticipant1;

    @FXML
    private TextField nameOfParticipant2;

    @FXML
    private TextField nameOfParticipant3;

    @FXML
    private TextField nameOfParticipant4;

    @FXML
    private TextField nameOfParticipant5;

    @FXML
    private TextField nameOfParticipant6;

    @FXML
    private TextField nameOfParticipant7;

    @FXML
    private TextField nameOfParticipant8;

    @FXML
    private TextField nameOfTeamOne;
    @FXML
    private TextField nameOfTeamTwo;
    @FXML
    private ChoiceBox<Participant> teamOnePlayerOneDropdown;

    @FXML
    private ChoiceBox<Participant> teamOnePlayerTwoDropdown;

    @FXML
    private ChoiceBox<Participant> teamTwoPlayerOneDropdown;
    @FXML
    private ChoiceBox<Participant> teamTwoPlayerTwoDropdown;
    @FXML
    private GridPane leftGrid;
    @FXML
    private GridPane rightGrid;
    @FXML
    private Button tournamentButton;
    @FXML
    private ChoiceBox<String> tournamentSystemDropdown;
    @FXML
    private GridPane tournamentSystemGrid;
    @FXML
    private Button setDoubleButton;

    @FXML
    private Label doubleLabel;

    @FXML
    void doubleButton(ActionEvent event) {
        leftGrid.setVisible(true);
        rightGrid.setVisible(true);
        doubleLabel.setVisible(true);
        setDoubleButton.setVisible(true);

        setupTeams();
        setupParticipants();
        setupParticipantsDropdown();
        setupSystemDropdown();
    }

    @FXML
    void setDoubleButton(ActionEvent event) {
        tournamentSystemGrid.setVisible(true);
        tournamentButton.setVisible(true);
    }

    @FXML
    void startTournamentButton(ActionEvent event) throws IOException {

        teamOnePlayerOneDropdown.getValue().doubleUnit = 1;
        teamOnePlayerTwoDropdown.getValue().doubleUnit = 1;
        teamTwoPlayerOneDropdown.getValue().doubleUnit = 1;
        teamTwoPlayerTwoDropdown.getValue().doubleUnit = 1;

        setDoubleForRemainingParticipants(teamOne.participants);
        setDoubleForRemainingParticipants(teamTwo.participants);

        setupDoubleMatches();
        setupSingleMatches();

        if (isWernerSchefflerSystem()) {
            createAdditionalWernerSchefflerMatches();
        }
        initializeNextStage();
    }

    public void setStageOne(Stage receivedStage) {
        stageOne = receivedStage;
    }

    private void setupTeams() {
        teamOne = new Team(nameOfTeamOne.getText());
        teamTwo = new Team(nameOfTeamTwo.getText());

        teamOneLabel.setText(teamOne.name);
        teamTwoLabel.setText(teamTwo.name);
    }

    public void setupParticipants() {
        teamOne.participants.set(1, new Participant(nameOfParticipant1.getText(), teamOne));
        teamOne.participants.set(2, new Participant(nameOfParticipant1.getText(), teamOne));
        teamOne.participants.set(3, new Participant(nameOfParticipant1.getText(), teamOne));
        teamOne.participants.set(4, new Participant(nameOfParticipant1.getText(), teamOne));

        teamTwo.participants.set(1, new Participant(nameOfParticipant1.getText(), teamTwo));
        teamTwo.participants.set(2, new Participant(nameOfParticipant1.getText(), teamTwo));
        teamTwo.participants.set(3, new Participant(nameOfParticipant1.getText(), teamTwo));
        teamTwo.participants.set(4, new Participant(nameOfParticipant1.getText(), teamTwo));
    }

    private void setupParticipantsDropdown() {
        ObservableList<Participant> t1nOb = FXCollections.observableList(teamOne.participants);
        ObservableList<Participant> t2nOb = FXCollections.observableList(teamTwo.participants);
        teamOnePlayerOneDropdown.setItems(t1nOb);
        teamOnePlayerTwoDropdown.setItems(t1nOb);
        teamTwoPlayerOneDropdown.setItems(t2nOb);
        teamTwoPlayerTwoDropdown.setItems(t2nOb);
    }

    private void setupSystemDropdown() {
        ObservableList<String> systems = FXCollections.observableArrayList("Bundessystem", "Werner-Scheffler-System");
        tournamentSystemDropdown.setItems(systems);
    }

    private void createAdditionalWernerSchefflerMatches() {

        matchFactory.createSingleMatch(teamOne.participants.get(3), teamTwo.participants.get(1));
        matchFactory.createSingleMatch(teamOne.participants.get(1), teamTwo.participants.get(3));
        matchFactory.createSingleMatch(teamOne.participants.get(2), teamTwo.participants.get(4));
        matchFactory.createSingleMatch(teamOne.participants.get(4), teamTwo.participants.get(2));
    }

    private void setDoubleForRemainingParticipants(ArrayList<Participant> participants) {
        for (Participant participant :
                participants) {
            if (participant.doubleUnit != 1) {
                participant.doubleUnit = 2;
            }
        }
    }

    private boolean isWernerSchefflerSystem() {
        return tournamentSystemDropdown.getValue() == "Werner-Scheffler-System";
    }

    private void setupSingleMatches() {

        matchFactory.createSingleMatch(teamOne.participants.get(1), teamTwo.participants.get(2));
        matchFactory.createSingleMatch(teamOne.participants.get(2), teamTwo.participants.get(1));
        matchFactory.createSingleMatch(teamOne.participants.get(3), teamTwo.participants.get(4));
        matchFactory.createSingleMatch(teamOne.participants.get(4), teamTwo.participants.get(3));
        matchFactory.createSingleMatch(teamOne.participants.get(1), teamTwo.participants.get(1));
        matchFactory.createSingleMatch(teamOne.participants.get(2), teamTwo.participants.get(2));
        matchFactory.createSingleMatch(teamOne.participants.get(3), teamTwo.participants.get(3));
        matchFactory.createSingleMatch(teamOne.participants.get(4), teamTwo.participants.get(4));
    }

    private ArrayList<Participant> getDoubleParticipants(ArrayList<Participant> participants, int doubleUnit) {
        ArrayList<Participant> doubleParticipants = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.doubleUnit == doubleUnit) {
                doubleParticipants.add(participant);
            }
        }
        return doubleParticipants;
    }

    private void setupDoubleMatches() {
        ArrayList<Participant> teamOneParticipants = getDoubleParticipants(teamOne.participants, 1);
        ArrayList<Participant> teamTwoParticipants = getDoubleParticipants(teamTwo.participants, 1);
        matchFactory.createDoubleMatch(teamOneParticipants, teamTwoParticipants);

    }

    private void initializeNextStage() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(Main.class.getResource("spectatorWindow.fxml"));

        Scene scene2 = new Scene(fxmlLoader2.load(), 620, 420);
        Scene scene3 = new Scene(fxmlLoader3.load(), 620, 420);
        Stage stageTwo = new Stage();

        MainController mc = fxmlLoader2.getController();
        mc.setMatches(matches);

        mc.setTeamOne(teamOne);
        mc.setTeamTwo(teamTwo);
        mc.initializeController();
        mc.setupMainTeamLabels();

        stageOne.setTitle("Tabletennistunier - Punkte setzen");
        stageOne.setScene(scene2);

        SpectatorController sc = fxmlLoader3.getController();
        mc.setSpectatorController(sc);
        mc.setWernerScheffler(isWernerSchefflerSystem());
        sc.getNameOfTeamOne().setText(teamOne.name);
        sc.getNameOfTeamTwo().setText(teamTwo.name);


        stageTwo.setTitle("TabletennisTunier - Zuschauer Augabe");
        stageTwo.setScene(scene3);
        stageTwo.show();
    }

}
