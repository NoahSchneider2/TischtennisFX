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

    private int matchConter = 1;



    @FXML
    private Label mannschaft1;

    @FXML
    private Label mannschaft2;
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
    private ChoiceBox<Participant> t1ds1;

    @FXML
    private ChoiceBox<Participant> t1ds2;

    @FXML
    private ChoiceBox<Participant> t2ds1;
    @FXML
    private ChoiceBox<Participant> t2ds2;
    @FXML
    private GridPane leftGrid;
    @FXML
    private GridPane rightGrid;
    @FXML
    private Button tunierButton;

    @FXML
    private Label doubleLabel;
    private Stage stageOne;

    public void setStageOne(Stage receivedStage)
    {
        stageOne = receivedStage;
    }

    @FXML
    void doubleButton(ActionEvent event) {
        leftGrid.setVisible(true);
        rightGrid.setVisible(true);
        doubleLabel.setVisible(true);
        tunierButton.setVisible(true);

        teamOne = new Team(nameOfTeamOne.getText());
        teamTwo = new Team(nameOfTeamTwo.getText());

        mannschaft1.setText(teamOne.getName());
        mannschaft2.setText(teamTwo.getName());


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
        // TODO: Zeile 68-76 mit einer Schleife irgendwie cooler machen?

        ObservableList<Participant> t1nOb = FXCollections.observableList(participantsOfTeamOne);
        ObservableList<Participant> t2nOb = FXCollections.observableList(participantsOfTeamTwo);
        t1ds1.setItems(t1nOb);
        t1ds2.setItems(t1nOb);
        t2ds1.setItems(t2nOb);
        t2ds2.setItems(t2nOb);
    }
    @FXML

        void tunierstartButton(ActionEvent event) throws IOException {
        if(!fourDifferentParticipantsSelected()) {
            System.out.println("Es wurden nicht 4 verschiedene Spieler für Doppel ausgewählt.");
            //TODO: Das wird hier nur in der Konsole ausgegeben, sollte aber als Pop-Up im Programm auftauchen. Kannst du das was machen, @Noah?
            return;
        }
            t1ds1.getValue().setDouble(1);
            t1ds2.getValue().setDouble(1);
            t2ds1.getValue().setDouble(1);
            t2ds2.getValue().setDouble(1);
            setDoubleForRemainingParticipants(allParticipants);
            createDoubleMatches();
            createSingleMatches();
            initializeNextStage();


    }

    private boolean fourDifferentParticipantsSelected() {

        ArrayList<String> participants = new ArrayList<>();
        participants.add(t1ds1.getValue().getName());
        participants.add(t1ds2.getValue().getName());
        participants.add(t2ds1.getValue().getName());
        participants.add(t2ds2.getValue().getName());
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
        matches.add(new Match(chooseParticipantsForMatch(1, 2), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(2, 1), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(3, 4), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(4, 3), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(1, 1), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(2, 2), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(3, 3), matchConter));
        raiseCounter();
        matches.add(new Match(chooseParticipantsForMatch(4, 4), matchConter));
        raiseCounter();

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

        matches.add(new Match(double1Participants, matchConter));
        raiseCounter();
        matches.add(new Match(double2Participants, matchConter));
        raiseCounter();
    }
    private void raiseCounter() {
        matchConter++;
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
        FXMLLoader fxmlLoader3 = new FXMLLoader(Main.class.getResource("showWindow.fxml"));

        Scene scene2 = new Scene(fxmlLoader2.load(), 620, 420);
        Scene scene3 = new Scene(fxmlLoader3.load(), 620, 420);
        Stage stageTwo = new Stage();

        MainController mainController = (MainController) fxmlLoader2.getController();
        mainController.setMatches(matches);

        mainController.setTeamOne(teamOne);
        mainController.setTeamTwo(teamTwo);

        stageOne.setTitle("Tabletennistunier - Punkte setzen");
        stageOne.setScene(scene2);
        stageTwo.setTitle("TabletennisTunier - Zuschauer Augabe");
        stageTwo.setScene(scene3);
        stageTwo.show();
    }

}
