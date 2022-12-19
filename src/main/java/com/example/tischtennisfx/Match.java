package com.example.tischtennisfx;

import java.util.ArrayList;

public class Match {

    public Match(ArrayList<Participant> participants, int matchNumber) {
        setMatchNumber(matchNumber);
        checkIfDoubleMatch(participants);
        setTeamsFromParticipants(participants);
        partParticipantsByTeam(participants);
    }

    private void setTeamsFromParticipants(ArrayList<Participant> participants) {
        for (Participant participant :
                participants) {
            if (teamOne == participant.getTeam() || teamTwo == participant.getTeam()) {
                continue;
            }
            if (teamOne != null) {
                setTeamTwo(participant.getTeam());
                continue;
            }
            setTeamOne(participant.getTeam());
        }
    }

    private Team winner;
    private int matchNumber;
    private boolean doubleMatch = false;
    private int pointsOfTeamOne = 0;
    private int pointsOfTeamTwo = 0;
    private Team teamOne;
    private Team teamTwo;
    public ArrayList<Participant> teamOneParticipants = new ArrayList<Participant>(); //TODO: Mal schauen wie wir das im Frontend ausgeben
    public ArrayList<Participant> teamTwoParticipants = new ArrayList<Participant>(); //TODO: Mal schauen wie wir das im Frontend ausgeben

    public Team getWinner() {
        return winner;
    }

    private void partParticipantsByTeam(ArrayList<Participant> participants) {
        for (Participant participant : participants) {
            if (participant.getTeam().getName() == teamOne.getName()) {
                teamOneParticipants.add(participant);
            } else {
                teamTwoParticipants.add(participant);
            }
        }
    }

    private void checkIfDoubleMatch(ArrayList<Participant> participantList) {
        if (participantList.size() == 4) {
            setDoubleMatch(true);
        }
    }

    public void setbackWinnerIfNeeded() {
        if ((pointsOfTeamOne + pointsOfTeamTwo < 5) && winner != null) {
            winner.subWonMatch();
            winner = null;
        }
    }

    public boolean hasEndScoreReached() {
        return pointsOfTeamOne + pointsOfTeamTwo == 5;
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public boolean isScoreNegative() {
        return pointsOfTeamOne < 0 || pointsOfTeamTwo < 0;
    }

    public void giveWinnerOnePoint() {
        if (pointsOfTeamOne > pointsOfTeamTwo) {
            winner = teamOne;
        } else {
            winner = teamTwo;
        }
        winner.addWonMatch();
    }

    public boolean isDoubleMatch() {
        return doubleMatch;
    }

    public void setDoubleMatch(boolean doubleMatch) {
        this.doubleMatch = doubleMatch;
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

    public void subPointToTeamOne() {
        pointsOfTeamOne--;
    }

    public void addPointToTeamTwo() {
        pointsOfTeamTwo++;
    }

    public void subPointToTeamTwo() {
        pointsOfTeamTwo--;
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

    @Override
    public String toString() {
        return "Match Nr. " + getMatchNumber();
    }
}
