package com.example.tischtennisfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList; // Package for the ArrayList
import javafx.collections.ObservableList; // Package for the ObservableList
import javafx.collections.FXCollections;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class startController {

    private ArrayList<Participant> allParticipants = new ArrayList<Participant>();
    private ArrayList<Participant> participantsOfTeam1 = new ArrayList<Participant>();
    private ArrayList<Participant> participantsOfTeam2 = new ArrayList<Participant>();

    private Team team1;
    private Team team2;

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
    private GridPane leftGrid;
    @FXML
    private GridPane rightGrid;
    @FXML
    private Button tunierButton;

    @FXML
    private Label doppelLabel;


    @FXML
    void doppelButton(ActionEvent event) {
        leftGrid.setVisible(true);
        rightGrid.setVisible(true);
        doppelLabel.setVisible(true);
        tunierButton.setVisible(true);

        team1 = new Team(nameOfTeam1.getText());
        team2 = new Team(nameOfTeam2.getText());

        mannschaft1.setText(team1.getName());
        mannschaft2.setText(team2.getName());


        participantsOfTeam1.add(new Participant(nameOfParticipant1.getText(), team1, 1));
        participantsOfTeam1.add(new Participant(nameOfParticipant2.getText(), team1, 2));
        participantsOfTeam1.add(new Participant(nameOfParticipant3.getText(), team1, 3));
        participantsOfTeam1.add(new Participant(nameOfParticipant4.getText(), team1, 4));

        participantsOfTeam2.add(new Participant(nameOfParticipant5.getText(), team2, 1));
        participantsOfTeam2.add(new Participant(nameOfParticipant6.getText(), team2, 2));
        participantsOfTeam2.add(new Participant(nameOfParticipant7.getText(), team2, 3));
        participantsOfTeam2.add(new Participant(nameOfParticipant8.getText(), team2, 4));
        allParticipants.addAll(participantsOfTeam1);
        allParticipants.addAll(participantsOfTeam2);
        // TODO: Zeile 68-76 mit einer Schleife irgendwie cooler machen?

        ObservableList<Participant> t1nOb = FXCollections.observableList(participantsOfTeam1);
        ObservableList<Participant> t2nOb = FXCollections.observableList(participantsOfTeam2);
        t1ds1.setItems(t1nOb);
        t1ds2.setItems(t1nOb);
        t2ds1.setItems(t2nOb);
        t2ds2.setItems(t2nOb);
    }
    Stage stage1;
    void setStage(Stage stage){
        stage1=stage;
    }
    Stage stage2;
    void setStage2(Stage stage){
        stage2=stage;
    }
    Scene scene2;
    void setScene2(Scene scene){
        scene2 = scene;
    }
    Scene scene3;
    void setScene3(Scene scene){
        scene3 = scene;
    }
    @FXML
    void tunierstartButton(ActionEvent event) {
        t1ds1.getValue().setDoppel(1);
        t1ds2.getValue().setDoppel(1);
        t1ds1.getValue().setDoppel(1);
        t1ds2.getValue().setDoppel(1);
        setDoppelForRemainingParticipants(allParticipants);
        createDoppelMatches();
        createSingleMatches();

        stage1.setTitle("TischtennisTunier");
        stage1.setScene(scene2);
        stage2.setTitle("TischtennisTunier");
        stage2.setScene(scene3);
        stage2.show();
    }


    private void setDoppelForRemainingParticipants(ArrayList<Participant> participants) {
        for (Participant participant :
                participants) {
            if (participant.getDoppel() != 1) {
                participant.setDoppel(2);
            }
        }
    }
    private void createSingleMatches() {
        new Match(chooseParticipantsForMatch(1, 2), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(2, 1), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(3, 4), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(4, 3), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(1, 1), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(2, 2), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(3, 3), matchConter);
        raiseCounter();
        new Match(chooseParticipantsForMatch(4, 4), matchConter);
        raiseCounter();

    }

    private void createDoppelMatches() {
        ArrayList<Participant> doppel1Participants = new ArrayList<Participant>();;
        ArrayList<Participant> doppel2Participants = new ArrayList<Participant>();;

        for (Participant participant :
                allParticipants) {
            if(participant.getDoppel() == 1) {
                doppel1Participants.add(participant);
                continue;
            }
            doppel2Participants.add(participant);
        }

        matches.add(new Match(doppel1Participants, matchConter));
        raiseCounter();
        matches.add(new Match(doppel2Participants, matchConter));
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
        participants.add(getParticipantByPosition(participantsOfTeam1, positionTeamOne));
        participants.add(getParticipantByPosition(participantsOfTeam2, positionTeamTwo));
        return participants;
    }
}
