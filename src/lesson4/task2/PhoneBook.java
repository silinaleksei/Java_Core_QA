package lesson4.task2;

import java.util.HashMap;

/*
Написать простой класс Телефонный Справочник,
который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.
 */
public class PhoneBook {
    private final HashMap<Integer, String> phonebook;

    public PhoneBook(HashMap<Integer, String> phonebook) {
        this.phonebook = phonebook;
    }

    public void add(Integer phonenumber, String surname) {
        phonebook.put(phonenumber, surname);
    }

    public String get(String surname) {
        if (phonebook.containsValue(surname)) {
            String result = "Phone numbers ";
            for (Integer key : phonebook.keySet()) {
                if (phonebook.get(key).equals(surname)) result += surname + ": " + key + "; ";
            }
            return result;
        } else return "Surname not found";

    }
}
