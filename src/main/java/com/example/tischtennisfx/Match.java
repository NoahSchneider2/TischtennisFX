package com.example.tischtennisfx;

import java.util.ArrayList;

public class Match {

    Match(ArrayList<Participant> participants, ArrayList<Team> teams, int matchNumber) {
        setMatchNumber(matchNumber);
        setTeamOne(teams.get(0));
        setTeamOne(teams.get(1));
        checkIfDoubleMatch(participants);
        partParticipantsByTeam(participants);
    }
    private int matchNumber;
    private boolean doppel = false;
    private int pointsOfTeamOne = 0;
    private int pointsOfTeamTwo = 0;
    private Team teamOne;
    private Team teamTwo;
    private ArrayList<Participant> teamOneParticipants = new ArrayList<Participant>(); //TODO: Mal schauen wie wir das im Frontend ausgeben
    private ArrayList<Participant> teamTwoParticipants = new ArrayList<Participant>(); //TODO: Mal schauen wie wir das im Frontend ausgeben
    private void partParticipantsByTeam(ArrayList<Participant> participants) {
        for (Participant participant: participants) {
            if(participant.getTeamName() == teamOne.getName()) {
                teamOneParticipants.add(participant);
            } else {
                teamTwoParticipants.add(participant);
            }
        }
    }

    private void checkIfDoubleMatch(ArrayList<Participant> spielerListe) {
        if(spielerListe.size() == 4) {
            setDoppel(true);
        }
    }

    public void checkWhoIsWinning() {
        if(pointsOfTeamOne == 3) {
            teamOne.addWonMatch();
        }
        if(pointsOfTeamTwo == 3) {
            teamTwo.addWonMatch();
        }
    }

    public boolean isDoppel() {
        return doppel;
    }

    public void setDoppel(boolean doppel) {
        this.doppel = doppel;
    }

    public int getPointsOfTeamOne() {
        return pointsOfTeamOne;
    }

    public int getPointsOfTeamTwo() {
        return pointsOfTeamTwo;
    }
    public void addPointToTeamOne() {
        pointsOfTeamOne++;
    }

    public void addPointToTeamTwo() {
        pointsOfTeamTwo++;
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


    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }
}
