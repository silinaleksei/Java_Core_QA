package lesson3.task2;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> fruitList;

    public Box(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public float getWeight() {
        float result = 0;
        for (T t : getFruitList()) {
            result += t.getWeight();
        }
        return result;
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }
    // box comparison method
    public Boolean compareBox(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }
    // method of adding fruit to the box
    public void addFruitToBox(T fruit, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.getFruitList().add(fruit);
        }
    }
    // method of transferring fruit to another box
public void refillingFruits (Box<T> box) {
        box.getFruitList().addAll(this.getFruitList());
    this.getFruitList().clear();
}


}
