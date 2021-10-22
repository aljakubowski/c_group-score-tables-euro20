package com.company;

public class Team implements Comparable<Team> {

    private final String name;
    int played;
    int won;
    int tied;
    int lost;
    int scoredGoals;
    int concededGoals;
    int goalDifference;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void matchResult(Team opponent, int teamScore, int opponentScore) {

        scoredGoals += teamScore;
        concededGoals += opponentScore;

        if (teamScore > opponentScore) {
            won++;
        } else if (teamScore == opponentScore) {
            tied++;
        } else {
            lost++;
        }
        played++;

        if (opponent != null) {
            opponent.matchResult(null, opponentScore, teamScore);
        }
    }

    public int gainedPoints() {
        return (won * 3 + tied);
    }

    public int goalDifference() {
        return goalDifference = scoredGoals - concededGoals;
    }

    @Override
    public int compareTo(Team team) {
        if (this.gainedPoints() > team.gainedPoints()) {
            return -1;
        } else if (this.gainedPoints() < team.gainedPoints()) {
            return 1;

        } else if (this.gainedPoints() == team.gainedPoints()) {
            if (this.goalDifference() > team.goalDifference()) {
                return -1;
            } else if (this.goalDifference() < team.goalDifference()) {
                return 1;
            }
        }
        return 0;
    }
}