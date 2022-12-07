package com.example.tischtennisfx;

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
import java.util.HashSet;
import java.util.Set;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SetupController {

    private final ArrayList<Participant> allParticipants = new ArrayList<Participant>();
    private final ArrayList<Participant> participantsOfTeamOne = new ArrayList<Participant>();
    private final ArrayList<Participant> participantsOfTeamTwo = new ArrayList<Participant>();

    private Team teamOne;
    private Team teamTwo;

    private final ArrayList<Match> matches = new ArrayList<Match>();

    private int matchCounter = 0;


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
    //TODO: Oof, gibts eine Möglichkeit die Felder zu gruppieren? @Noah
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
    private Button tunierButton;
    @FXML
    private ChoiceBox<?> tunierSystemDropdown;
    @FXML
    private GridPane tunierSystemGrid;
    @FXML
    private Button setDoubleButton;

    @FXML
    private Label doubleLabel;
    private Stage stageOne;

    public void setStageOne(Stage receivedStage) {
        stageOne = receivedStage;
    }

    @FXML
    void doubleButton(ActionEvent event) {
        leftGrid.setVisible(true);
        rightGrid.setVisible(true);
        doubleLabel.setVisible(true);
        setDoubleButton.setVisible(true);



        teamOne = new Team(nameOfTeamOne.getText());
        teamTwo = new Team(nameOfTeamTwo.getText());

        teamOneLabel.setText(teamOne.getName());
        teamTwoLabel.setText(teamTwo.getName());

        participantsOfTeamOne.add(new Participant(nameOfParticipant1.getText(), teamOne, 1));
        participantsOfTeamOne.add(new Participant(nameOfParticipant2.getText(), teamOne, 2));
        participantsOfTeamOne.add(new Participant(nameOfParticipant3.getText(), teamOne, 3));
        participantsOfTeamOne.add(new Participant(nameOfParticipant4.getText(), teamOne, 4));

        participantsOfTeamTwo.add(new Participant(nameOfParticipant5.getText(), teamTwo, 1));
        participantsOfTeamTwo.add(new Participant(nameOfParticipant6.getText(), teamTwo, 2));
        participantsOfTeamTwo.add(new Participant(nameOfParticipant7.getText(), teamTwo, 3));
        participantsOfTeamTwo.add(new Participant(nameOfParticipant8.getText(), teamTwo, 4));
        allParticipants.addAll(participantsOfTeamOne);
        allParticipants.addAll(participantsOfTeamTwo);

        ObservableList<Participant> t1nOb = FXCollections.observableList(participantsOfTeamOne);
        ObservableList<Participant> t2nOb = FXCollections.observableList(participantsOfTeamTwo);
        teamOnePlayerOneDropdown.setItems(t1nOb);
        teamOnePlayerTwoDropdown.setItems(t1nOb);
        teamTwoPlayerOneDropdown.setItems(t2nOb);
        teamTwoPlayerTwoDropdown.setItems(t2nOb);
    }


    @FXML
    void setDoubleButton(ActionEvent event) {
        tunierSystemGrid.setVisible(true);
        tunierButton.setVisible(true);
    }

    @FXML
    void startTournamentButton(ActionEvent event) throws IOException {
        if (!fourDifferentParticipantsSelected()) {
            if(errorLabel != null) {
                errorLabel.setText("Es wurden nicht 4 verschiedene Spieler für Doppel ausgewählt.");
            }
            return;
        }
        if(errorLabel != null) {
            errorLabel.setText("");
        }
        teamOnePlayerOneDropdown.getValue().setDouble(1);
        teamOnePlayerTwoDropdown.getValue().setDouble(1);
        teamTwoPlayerOneDropdown.getValue().setDouble(1);
        teamTwoPlayerTwoDropdown.getValue().setDouble(1);
        setDoubleForRemainingParticipants(allParticipants);
        createSingleMatches();
        createDoubleMatches();
//        if (isWernerSchefflerSystem()) {
//            createAdditionalWernerSchefflerMatches();
//        }
        initializeNextStage();
    }
    private void createAdditionalWernerSchefflerMatches() {
        matches.add(new Match(chooseParticipantsForMatch(3, 1), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(1, 3), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(2, 4), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(4, 2), matchCounter));
        raiseCounter();
    }
    private boolean fourDifferentParticipantsSelected() {

        ArrayList<String> participants = new ArrayList<>();
        participants.add(teamOnePlayerOneDropdown.getValue().getName());
        participants.add(teamOnePlayerTwoDropdown.getValue().getName());
        participants.add(teamTwoPlayerOneDropdown.getValue().getName());
        participants.add(teamTwoPlayerTwoDropdown.getValue().getName());
        Set<String> set = new HashSet<String>(participants);
        return set.size() >= participants.size();
    }

    private void setDoubleForRemainingParticipants(ArrayList<Participant> participants) {
        for (Participant participant :
                participants) {
            if (participant.getDouble() != 1) {
                participant.setDouble(2);
            }
        }
    }

    private void createSingleMatches() {
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(1, 2), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(3, 4), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(3, 4), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(4, 3), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(1, 1), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(2, 2), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(3, 3), matchCounter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(4, 4), matchCounter));

    }

    private void createDoubleMatches() {
        ArrayList<Participant> double1Participants = new ArrayList<Participant>();
        ArrayList<Participant> double2Participants = new ArrayList<Participant>();

        for (Participant participant :
                allParticipants) {
            if(participant.getDouble() == 1) {
                double1Participants.add(participant);
                continue;
            }
            double2Participants.add(participant);
        }
        raiseCounter();
        matches.add(new Match(double1Participants, matchCounter));
        raiseCounter();
        matches.add(new Match(double2Participants, matchCounter));
    }

    private void raiseCounter() {
        matchCounter++;
    }

    private Participant getParticipantByPosition(ArrayList<Participant> participants, int position) {
        for (Participant participant :
                participants) {
            if (participant.getPosition() == position) {
                return participant;
            }
        }
        throw new RuntimeException();
    }
    private ArrayList<Participant> chooseParticipantsForMatch(int positionTeamOne, int positionTeamTwo) {
        ArrayList<Participant> participants = new ArrayList<Participant>();
        participants.add(getParticipantByPosition(participantsOfTeamOne, positionTeamOne));
        participants.add(getParticipantByPosition(participantsOfTeamTwo, positionTeamTwo));
        return participants;
    }
    private void initializeNextStage() throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(Main.class.getResource("spectatorWindow.fxml"));

        Scene scene2 = new Scene(fxmlLoader2.load(), 620, 420);
        Scene scene3 = new Scene(fxmlLoader3.load(), 620, 420);
        Stage stageTwo = new Stage();

        MainController mainController = (MainController) fxmlLoader2.getController();
        mainController.setMatches(matches);

        mainController.setTeamOne(teamOne);
        mainController.setTeamTwo(teamTwo);
        mainController.initializeController();
        mainController.setupMainTeamLabels();

        stageOne.setTitle("Tabletennistunier - Punkte setzen");
        stageOne.setScene(scene2);

        SpectatorController scoreController = (SpectatorController) fxmlLoader3.getController();
        mainController.setSpectatorController(scoreController);
        scoreController.getNameOfTeamOne().setText(teamOne.getName());
        scoreController.getNameOfTeamTwo().setText(teamTwo.getName());


        stageTwo.setTitle("TabletennisTunier - Zuschauer Augabe");
        stageTwo.setScene(scene3);
        stageTwo.show();
    }

}
