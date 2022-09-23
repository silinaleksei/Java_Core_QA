package lesson1;

public class Course {
    private final int runTrackLength;
    private final int swimTrackLength;
    private final double wallHeight;
    static String result;

    Course(int runTrackLength, int swimTrackLength, double wallHeight) {
        this.runTrackLength = runTrackLength;
        this.swimTrackLength = swimTrackLength;
        this.wallHeight = wallHeight;
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
        if (value >= runTrackLength) result += "The race is completed";
        else result += "The race isn't completed";
    }

    private void testSwim(int value) {
        if (value >= swimTrackLength) result += ", The swim is completed";
        else result += ", The swim isn't completed";
    }

    private void testJump(double value) {
        if (value >= wallHeight) result += ", The height is taken" + '\n';
        else result += ", The height isn't taken " + '\n';
    }

    @Override
    public String toString() {
        return "Course: {" +
                "Length of the run track = " + runTrackLength +
                "m, Length of the swim track = " + swimTrackLength + "m, " +
                "Height of the wall = " + wallHeight + "m" +
                '}';
    }


}
