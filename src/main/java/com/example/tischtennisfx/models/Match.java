package com.example.tischtennisfx.models;

import java.util.ArrayList;

public class Match {
    public  ArrayList<Participant> teamOneParticipants;
    public  ArrayList<Participant> teamTwoParticipants;
    private Team winner;
    public boolean doubleMatch;
    private int pointsOfTeamOne = 0;
    private int pointsOfTeamTwo = 0;
    private final Team teamOne;
    private final Team teamTwo;

    public Match(ArrayList<Participant> teamOneParticipants, ArrayList<Participant> teamTwoParticipants) {
        this.teamOneParticipants = teamOneParticipants;
        this.teamTwoParticipants = teamOneParticipants;
        teamOne = teamOneParticipants.get(1).team;
        teamTwo = teamTwoParticipants.get(1).team;
    }

    public void setBackWinnerIfNeeded() {
        if ((pointsOfTeamOne + pointsOfTeamTwo < 5) && winner != null) {
            winner.removeWonMatch();
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
}
