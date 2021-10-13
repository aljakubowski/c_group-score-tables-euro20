package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Group<T extends Team> {

    private String name;
    private ArrayList<T> leagueTeams = new ArrayList<>();
    int matchCount = 0;

    public Group(String name, T team1, T team2, T team3, T team4 ) {
        this.name = name;
        leagueTeams.add(team1);
        leagueTeams.add(team2);
        leagueTeams.add(team3);
        leagueTeams.add(team4);
    }

    public Group(String name, T team1, T team2, T team3, T team4, T team5, T team6) {
        this.name = name;
        leagueTeams.add(team1);
        leagueTeams.add(team2);
        leagueTeams.add(team3);
        leagueTeams.add(team4);
        leagueTeams.add(team5);
        leagueTeams.add(team6);
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getLeagueTeams() {
        return leagueTeams;
    }

    public Team getThird(){
        return this.leagueTeams.get(2);
    }

    public void groupList(){
        int i = 0;
        for (T t: leagueTeams){
            i++;
            System.out.println(i+ " " + t.getName());
        }
    }


    public void leagueTable(){

        System.out.println("-----------------------------------------------------------------------");
        System.out.println(
                "Group " + this.getName() + " table: \t\t\t" + "pts"+ "\t\t" + "games"+ "\t" + "won"+ "\t  " + "tied" + "\t " + "lost" +
                "\t" + "goals +/-");

        Collections.sort(leagueTeams);
        int i = 0;
        for (T t: leagueTeams){
            i++;
            System.out.println( i +". " + " " + t.getName() + "\t\t\t" + t.gainedPoints() +
                    "\t  |  " +t.played+ "\t\t " +t.won+ "\t\t" +t.tied+ "\t  " +t.lost +
                    "\t\t" + t.goalDifference());
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void matchResult(T team1, T team2, int team1Score, int team2Score) {
        this.matchCount++;

        if (matchCount<=6) {
            int position = leagueTeams.indexOf(team1);
            leagueTeams.get(position).matchResult(team2, team1Score, team2Score);
        } else {
            System.out.println("Invalid, all matches in group " + this.getName()+ " played");
        }
    }
}
