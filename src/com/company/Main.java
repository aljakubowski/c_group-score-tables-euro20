package com.company;

public class Main {

    public static void main(String[] args) {

        // == TEAMS & GROUPS ====================================================

        Team france = new Team("France  ");
        Team germany = new Team("Germany ");
        Team portugal = new Team("Portugal");
        Team hungary = new Team("Hungary ");

        Group<Team> groupF = new Group<>("F", france, germany, portugal, hungary);

        Team poland = new Team("Poland  ");
        Team spain = new Team("Spain   ");
        Team sweden = new Team("Sweden  ");
        Team slovakia = new Team("Slovakia");

        Group<Team> groupE = new Group<>("E", poland, slovakia, spain, sweden);

        Team england = new Team("England ");
        Team croatia = new Team("Croatia ");
        Team czech = new Team("Czech   ");
        Team scotland = new Team("Scotland");

        Group<Team> groupD = new Group<>("D",england,croatia,czech,scotland);

        Team netherla = new Team("Netherla");
        Team austria = new Team("Austria  ");
        Team ukraine = new Team("Ukraine  ");
        Team macedon = new Team("Macedon  ");

        Group<Team> groupC = new Group<Team>("C",netherla,austria,ukraine,macedon);

        Team belgium = new Team("Belgium  ");
        Team denmark = new Team("Denmark  ");
        Team finland = new Team("Finland  ");
        Team russia = new Team("Russia  ");

        Group<Team> groupB = new Group<Team>("B",belgium,denmark,finland,russia);

        Team italy = new Team("Italy   ");
        Team wales = new Team("Wales   ");
        Team switzerland = new Team("Switz   ");
        Team turkey = new Team("Turkey  ");

        Group<Team> groupA = new Group<Team>("A",italy,wales,switzerland,turkey);


        // == RESULTS =======================================================

        groupF.matchResult(hungary,portugal,0,3);
        groupF.matchResult(france,germany,1,0);
        groupF.matchResult(hungary,france,1,1);
        groupF.matchResult(portugal,germany,2,4);
        groupF.matchResult(germany,hungary,2,2);
        groupF.matchResult(portugal,france,2,2);

        groupE.matchResult(poland,slovakia,1,2);
        groupE.matchResult(spain,sweden,0,0);
        groupE.matchResult(sweden,slovakia,1,0);
        groupE.matchResult(spain,poland,1,1);
        groupE.matchResult(sweden,poland,3,2);
        groupE.matchResult(slovakia,spain,0,5);

        groupD.matchResult(england,croatia,1,0);
        groupD.matchResult(scotland,czech,0,2);
        groupD.matchResult(croatia,czech,1,1);
        groupD.matchResult(england,scotland,0,0);
        groupD.matchResult(czech,england,0,1);
        groupD.matchResult(croatia,scotland,3,1);

        groupC.matchResult(austria,macedon,3,1);
        groupC.matchResult(netherla,ukraine,3,2);
        groupC.matchResult(ukraine,macedon,2,1);
        groupC.matchResult(netherla,austria,2,0);
        groupC.matchResult(ukraine,austria,0,1);
        groupC.matchResult(macedon,netherla,0,3);

        groupB.matchResult(denmark,finland,0,1);
        groupB.matchResult(belgium,russia,3,0);
        groupB.matchResult(finland,russia,0,1);
        groupB.matchResult(denmark,belgium,1,2);
        groupB.matchResult(finland,belgium,0,2);
        groupB.matchResult(russia,denmark,1,4);

        groupA.matchResult(turkey,italy,0,3);
        groupA.matchResult(wales,switzerland,1,1);
        groupA.matchResult(turkey,wales,0,2);
        groupA.matchResult(italy,switzerland,3,0);
        groupA.matchResult(italy,wales,1,0);
        groupA.matchResult(switzerland,turkey,3,1);

        Group<Team> group3 = new Group<>("3",
                groupA.getThird(), groupB.getThird(), groupC.getThird(),
                groupD.getThird(), groupE.getThird(), groupF.getThird());
        group3.leagueTable();


        // == TABLES =======================================================
        groupF.leagueTable();
        groupE.leagueTable();
        groupD.leagueTable();
        groupC.leagueTable();
        groupB.leagueTable();
        groupA.leagueTable();


    }
}
