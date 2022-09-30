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
        System.out.println(appleBox.compareBox(orangeBox)); // true - ������� ������ �� ����
        appleBox.addFruitToBox(apple, 1); // ��������� 1 ������ � �������
        System.out.println(appleBox.getWeight()); // 7 - ��� ������� ����� ���������� 1 ������
        //appleBox.addFruitToBox(orange,1); // ������ ����������: ������ �������� �������� � ������� � ��������
        orangeBox.addFruitToBox(orange, 2); // ��������� 2 ��������� � �������
        System.out.println(orangeBox.getWeight()); // 9 - ��� ������� ����� ���������� 2 ����������
        System.out.println(appleBox.compareBox(orangeBox)); // false - ������ ������� ������ �� ����
        ArrayList<Apple> applesList1 = new ArrayList<>(10);
        Box<Apple> appleBox1 = new Box<>(applesList1); // ����� ������� ��� ������
        System.out.println(appleBox1.getWeight()); // 0 - ������� appleBox1 ������
        appleBox.refillingFruits(appleBox1); // ���������� �� ������� appleBox � �������  appleBox1
        System.out.println(appleBox.getWeight()); // 0 - ������� appleBox ������ ����� �����������
        System.out.println(appleBox1.getWeight()); // 7 - ��� ������� appleBox1 ����� �����������
        //Box<Orange> orangeBox1 = new Box<>(orangesList); // ����� ������� ��� ���������
        //appleBox.refillingFruits(orangeBox1); // ������ ����������: ������ ���������� ������ � ������� � �����������

    }
}
