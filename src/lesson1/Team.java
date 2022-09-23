package lesson1;

import java.util.Arrays;

public class Team {
    private final String teamName;
    TeamMember[] members;

    public Team(String teamName, TeamMember[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    // метод вывода информации обо всех членах команды.
    @Override
    public String toString() {
        return "Team {" +
                "Name of the team = " + teamName +
                ", members of the team = " + Arrays.toString(members) +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public TeamMember[] getMembers() {
        return members;
    }

    public void showResults() {
        System.out.println(Course.result);
    }

}
