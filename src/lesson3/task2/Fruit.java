package lesson3.task2;

public abstract class Fruit {
    private final float weight;

    public Fruit(String name, float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
