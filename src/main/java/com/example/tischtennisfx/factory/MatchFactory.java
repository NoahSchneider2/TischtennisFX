package com.example.tischtennisfx.factory;

import com.example.tischtennisfx.models.Match;
import com.example.tischtennisfx.models.Participant;

import java.util.ArrayList;

public class MatchFactory {
    private int matchCounter = 1;
    private final ArrayList<Match> matches = new ArrayList<>();
    public void createDoubleMatch(ArrayList<Participant> teamOneParticipants, ArrayList<Participant> teamTwoParticipants) {
        Match doublematch = new Match(teamOneParticipants, teamTwoParticipants);
        doublematch.doubleMatch = true;
        matches.set(matchCounter, doublematch);
        matchCounter++;
    }

    public void createSingleMatch(Participant teamOneParticipant,Participant teamTwoParticipant) {
        Match singleMatch = new Match(participantHandler(teamOneParticipant), participantHandler(teamTwoParticipant));
        singleMatch.doubleMatch = false;
        matches.set(matchCounter, singleMatch);
        matchCounter++;
    }
    private ArrayList<Participant> participantHandler(Participant participant) {
        ArrayList<Participant> participantArrayList = new ArrayList<>();
        participantArrayList.set(1, participant);
        return participantArrayList;
    }
    public ArrayList<Match> getMatches() {
        return matches;
    }
}
