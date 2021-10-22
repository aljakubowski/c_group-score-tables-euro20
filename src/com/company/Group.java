package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Group<T extends Team> {

    private final String name;
    private final List<T> groupTeams;
    int matchCount = 0;

    public Group(Map<String, List<T>> groupTeams) {
        Map.Entry<String, List<T>> entry = groupTeams.entrySet().iterator().next();
        this.name = entry.getKey();
        this.groupTeams = entry.getValue();
    }

    public String getName() {
        return "Group " + name;
    }

    public Team getThird() {
        return this.groupTeams.get(2);
    }

    public void matchResult(T team1, T team2, int team1Score, int team2Score) {
        this.matchCount++;

        if (matchCount <= 6) {
            int position = groupTeams.indexOf(team1);
            groupTeams.get(position).matchResult(team2, team1Score, team2Score);
        } else {
            System.out.println("Invalid, all matches in group " + this.getName() + " played");
        }
    }

    public void leagueTable() {

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Group " + this.name + " table: \t\t\t" +
                "pts" + "\t\t" + "games" + "\t" + "won" + "\t  " + "tied" + "\t " + "lost" + "\t" + "goals +/-");

        Collections.sort(groupTeams);
        int i = 0;
        for (T t : groupTeams) {
            i++;
            System.out.println(i + ". " + " " + t.getName() + "\t\t\t" + t.gainedPoints() +
                    "\t  |  " + t.played + "\t\t " + t.won + "\t\t" + t.tied + "\t  " + t.lost +
                    "\t\t" + t.goalDifference());
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}