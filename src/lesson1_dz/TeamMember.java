package lesson1_dz;

public class TeamMember {
    private final String nameMember;
    private final int runAble;
    private final int swimAble;
    private final double jumpAble;

    TeamMember(String nameMember, int runAble, int swimAble, double jumpAble) {
        this.nameMember = nameMember;
        this.runAble = runAble;
        this.swimAble = swimAble;
        this.jumpAble = jumpAble;
    }

    public String getNameMember() {
        return nameMember;
    }

    public int getRunAble() {
        return runAble;
    }

    public int getSwimAble() {
        return swimAble;
    }

    public double getJumpAble() {
        return jumpAble;
    }

    @Override
    public String toString() {
        return "Team's member: {" +
                "Name = " + nameMember + '\'' +
                ", runAble = " + runAble + "m" +
                ", swimAble = " + swimAble + "m" +
                ", jumpAble = " + jumpAble + "m" +
                '}';
    }
}