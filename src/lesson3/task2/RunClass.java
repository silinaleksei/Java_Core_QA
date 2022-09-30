package lesson3.task2;

import java.util.ArrayList;

public class RunClass {
    public static void main(String[] args) {
        ArrayList<Apple> applesList = new ArrayList<>(10);
        Apple apple = new Apple();
        Orange orange = new Orange();
        applesList.add(apple);
        applesList.add(apple);
        applesList.add(apple);
        applesList.add(apple);
        applesList.add(apple);
        applesList.add(apple);
        ArrayList<Orange> orangesList = new ArrayList<>(10);
        orangesList.add(orange);
        orangesList.add(orange);
        orangesList.add(orange);
        orangesList.add(orange);
        Box<Apple> appleBox = new Box<>(applesList);
        Box<Orange> orangeBox = new Box<>(orangesList);
        System.out.println(appleBox.getWeight()); // 6
        System.out.println((orangeBox.getWeight())); // 6
        System.out.println(appleBox.compareBox(orangeBox)); // true - коробки равные по весу
        appleBox.addFruitToBox(apple, 1); // добавл€ем 1 €блоко в коробку
        System.out.println(appleBox.getWeight()); // 7 - вес коробки после добавлени€ 1 €блока
        //appleBox.addFruitToBox(orange,1); // ошибка компил€ции: нельз€ добавить апельсин в коробку с €блоками
        orangeBox.addFruitToBox(orange, 2); // добавл€ем 2 апельсина в коробку
        System.out.println(orangeBox.getWeight()); // 9 - вес коробки после добавлени€ 2 апельсинов
        System.out.println(appleBox.compareBox(orangeBox)); // false - теперь коробки разные по весу
        ArrayList<Apple> applesList1 = new ArrayList<>(10);
        Box<Apple> appleBox1 = new Box<>(applesList1); // нова€ коробка под €блоки
        System.out.println(appleBox1.getWeight()); // 0 - коробка appleBox1 пуста€
        appleBox.refillingFruits(appleBox1); // пересыпаем из коробки appleBox в коробку  appleBox1
        System.out.println(appleBox.getWeight()); // 0 - коробка appleBox пуста€ после пересыпани€
        System.out.println(appleBox1.getWeight()); // 7 - вес коробки appleBox1 после пересыпани€
        //Box<Orange> orangeBox1 = new Box<>(orangesList); // нова€ коробка под апельсины
        //appleBox.refillingFruits(orangeBox1); // ошибка компил€ции: нельз€ пересыпать €блоки в коробку с апельсинами

    }
}
