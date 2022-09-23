package lesson1_dz;

public class Obstacle {
    private final String name;
    private final double value;

    Obstacle(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + name + ": " + value + "m" +'}';
    }

    public double getValue() {return value;}
}
