package lesson4.task2;

import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        HashMap<Integer, String> phonebook1 = new HashMap<>();
        PhoneBook phoneBook = new PhoneBook(phonebook1);
        phoneBook.add(123, "Ivanov");
        phoneBook.add(124, "Ivanov");
        phoneBook.add(125, "Petrov");
        phoneBook.add(126, "Petrov");
        phoneBook.add(127, "Sidorov");

        System.out.println(phoneBook.get("Ivanov")); // Phone numbers Ivanov: 123; Ivanov: 124;
        System.out.println(phoneBook.get("Petrov")); // Phone numbers Petrov: 125; Petrov: 126;
        System.out.println(phoneBook.get("Ivan")); // Surname not found

    }
}
