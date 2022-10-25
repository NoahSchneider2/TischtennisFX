package com.example.tischtennisfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList; // Package for the ArrayList
import javafx.collections.ObservableList; // Package for the ObservableList
import javafx.collections.FXCollections;

public class HelloController {

    private final ArrayList<Participant> participantsOfTeam1 = new ArrayList<Participant>();
    private final ArrayList<Participant> participantsOfTeam2 = new ArrayList<Participant>();

    private Team team1;
    private Team team2;

    private final ArrayList<Match> matches = new ArrayList<Match>();


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
    private TextField nameOfTeam1;
    @FXML
    private TextField nameOfTeam2;
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
    void doppelButton(ActionEvent event) {
        team1 = new Team(nameOfTeam1.getText());
        team2 = new Team(nameOfTeam2.getText());

        participantsOfTeam1.add(new Participant(nameOfParticipant1.getText(), team1));
        participantsOfTeam1.add(new Participant(nameOfParticipant2.getText(), team1));
        participantsOfTeam1.add(new Participant(nameOfParticipant3.getText(), team1));
        participantsOfTeam1.add(new Participant(nameOfParticipant4.getText(), team1));

        participantsOfTeam2.add(new Participant(nameOfParticipant5.getText(), team2));
        participantsOfTeam2.add(new Participant(nameOfParticipant6.getText(), team2));
        participantsOfTeam2.add(new Participant(nameOfParticipant7.getText(), team2));
        participantsOfTeam2.add(new Participant(nameOfParticipant8.getText(), team2));
        // TODO: Zeile 68-76 mit einer Schleife irgendwie cooler machen?

        ObservableList<Participant> t1nOb = FXCollections.observableList(participantsOfTeam1);
        ObservableList<Participant> t2nOb = FXCollections.observableList(participantsOfTeam2);
        t1ds1.setItems(t1nOb);
        t1ds2.setItems(t1nOb);
        t2ds1.setItems(t2nOb);
        t2ds2.setItems(t2nOb);
    }

    @FXML
    void tunierstartButton(ActionEvent event) {
        t1ds1.getValue().setDoppel(1);
        t1ds2.getValue().setDoppel(1);
        t1ds1.getValue().setDoppel(1);
        t1ds2.getValue().setDoppel(1);
        setDoppelForRemainingParticipants(participantsOfTeam1);
        setDoppelForRemainingParticipants(participantsOfTeam2);
        //TODO: Funktion die alle Matches erstellt.
    }

    private void setDoppelForRemainingParticipants(ArrayList<Participant> participants) {
        for (Participant participant :
                participants) {
            if (participant.getDoppel() != 1) {
                participant.setDoppel(2);
            }
        }
    }
    private void createMatches() {

        new Match()
    }

    private Match createDoppelMatches() {
        ArrayList<Participant> doppel1Participants = new ArrayList<Participant>();;
        ArrayList<Participant> doppel2Participants = new ArrayList<Participant>();;

        for (Participant participant :
                participantsOfTeam1) {
            if(participant.getDoppel() == 1) {
                doppel1Participants.add(participant);
                continue;
            }
            doppel2Participants.add(participant);
        }
        new Match(doppel1Participants, )
    }
}
