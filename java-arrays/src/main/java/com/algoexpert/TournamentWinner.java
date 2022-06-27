package com.algoexpert;

import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {

    }

    /*
    * There's an algorithms tournament taking place in which teams of programmers compete
against each other to solve algorithmic problems as fast as possible.Teams compete ina
round robin,where each team faces off against all other teams.Only two teams compete
against each other at a time,and for each competition,one team is designated the home
team,while the other team is the away team.In each competition there's always one winner
and one loser;there are no ties.A team receives 3points if it wins and 0points if it loses.The
winner of the tournament is the team that receives the most amount of points.
Given an array of pairs representing the teams that have competed against each other and an
array containing the results of each competition,write a function that returns the winner of
the tournament.The input arrays are named competitions and results,respectively.
The competitions array has elements in the form of[homeTeam,awayTeam],where
each team is a string of at most 30 characters representing the name of the team.The
 results array contains information about the winner of each corresponding competition in
the competitions array.Specifically,results[i]denotes the winner of
competitions[i],where a1 in the results array means that the home team in the
corresponding competition won and a means that the away team won.
It's guaranteed that exactly one team will win the tournament and that each team will
compete against all other teams exactly once.It's also guaranteed that the tournament will
always have at least two teams.
*
* Sample Input

* competitions[
 ["HTML","C#"],
 ["C#","Python"],
 ["Python","HTML"],
]
results=[0,0,1]
*
Sample Output

"Python"
//C# beats HTML,Python Beats C#,and Python Beats HTML.
// HTML-0points
//C#-3points
// Python-6points
* */

    public int HOME_TEAM_WON = 1;


    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentBestTeam = "";
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put(currentBestTeam, 0);
        for (int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> competition = competitions.get(idx);
            int result = results.get(idx);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;
            updateScores(winningTeam, 3, scores);
            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }
        return currentBestTeam;
    }


    public void updateScores(String team, int points, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + points);
    }
}
