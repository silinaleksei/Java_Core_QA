package lesson1_dz;

import java.util.Arrays;

public class Course {
   private final String name;
   Obstacle[] obstacles;
    static String result;

    Course(String name, Obstacle[] obstacles) {
        this.name = name;
        this.obstacles = obstacles;
    }

   public void doIt(Team team) {
        result = "Team: " + team.getTeamName() + ": " + '\n';
        for (TeamMember members : team.getMembers()) {
            result += members.getNameMember() + ("'s result: ");
            int value = members.getRunAble();
            int value1 = members.getSwimAble();
            double value2 = members.getJumpAble();
            testRun(value);
            testSwim(value1);
            testJump(value2);
        }
    }

    private void testRun(int value) {
        if (value >= obstacles[0].getValue()) result += "The race is completed";
        else result += "The race isn't completed";
    }

    private void testSwim(int value) {
        if (value >= obstacles[1].getValue()) result += ", The swim is completed";
        else result += ", The swim isn't completed";
    }

    private void testJump(double value) {
        if (value >= obstacles[2].getValue()) result += ", The height is taken" + '\n';
        else result += ", The height isn't taken " + '\n';
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ": obstacles: " + Arrays.toString(obstacles) +
                '}';
    }
//    public String toString() {
//        return "Course: {" +
//                "Length of the run track = " + runTrackLength +
//                "m, Length of the swim track = " + swimTrackLength + "m, " +
//                "Height of the wall = " + wallHeight + "m" +
//                '}';
//    }


}
