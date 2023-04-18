package FixtureGenerate;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Fixture {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> team = new ArrayList<>();
    ArrayList<String> moreTeam = new ArrayList<>();
    int fixtureValue = 0;

    Random r = new Random();

    public void run() {
        boolean status = true;
        int select;
        while (status) {
            System.out.println("1 - Add Team 2 - Create Fixture 0 - Quit");
            System.out.println("---------------");
            select = scan.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Please add a Team Name : ");
                    scan.nextLine();
                    String teamName = scan.nextLine();
                    team.add(teamName);
                    System.out.println("Team added" + team.get(team.size() - 1));
                    System.out.println("-------------------------------");
                    break;
                case 2:
                    createFixture();
                    break;
                case 0:
                    status = false;
                default:
                    System.out.println("Please enter a valid job");

            }

        }

    }

    public void createFixture() {
        if (team.size() % 2 != 0) {
            team.add("Bay");

            for (int i = 0; i < team.size(); i++) {
                String away;
                String home;
                int trueMatch = 0;
                String selectTeams = "";

                while (trueMatch < team.size() / 2) {
                    away = team.get(r.nextInt(team.size()));
                    home = team.get(r.nextInt(team.size()));
                    if (!away.equals(home)) {
                        if (!selectTeams.contains(away) && !selectTeams.contains(home)) {
                            String match1 = (away + " vs " + home);
                            String match2 = (home + " vs" + home);
                            if (!moreTeam.contains(match1) && !moreTeam.contains(match2)) ;
                            {
                                moreTeam.add(match1);
                                moreTeam.add(match2);

                                selectTeams += home;
                                selectTeams += away;
                                trueMatch++;
                            }
                        }
                    }
                }
            }
            printFixture();
        }
    }


    public void printFixture() {
        for (int bringMeet = 0; bringMeet < moreTeam.size(); bringMeet += 2) {
            fixtureValue++;
            System.out.println("--------Fixture : " + fixtureValue + "---------");
            int fixtureCounter = 0;
            while (fixtureCounter < team.size() / 2) {
                System.out.println(moreTeam.get(bringMeet));
                fixtureCounter++;
                bringMeet += 2;
                if (bringMeet <= moreTeam.size())
                    break;
            }
            bringMeet -= 2;

        }
        for (int bringMeet = 1; bringMeet < moreTeam.size(); bringMeet += 2) {
            fixtureValue++;
            System.out.println("--------Fixture " + fixtureValue + "--------");
            int fixtureCounter = 0;
            while (fixtureCounter < team.size() / 2) {
                System.out.println(moreTeam.get(bringMeet));
                fixtureCounter++;
                bringMeet += 2;
                if ((bringMeet < moreTeam.size())) {
                    break;
                }
            }
            bringMeet -= 2;
        }
    }
}

