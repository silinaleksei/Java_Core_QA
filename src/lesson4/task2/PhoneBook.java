package lesson4.task2;

import java.util.HashMap;

/*
�������� ������� ����� ���������� ����������,
������� ������ � ���� ������ ������� � ���������� �������.
� ���� ���������� ���������� � ������� ������ add() ����� ��������� ������,
� � ������� ������ get() ������ ����� �������� �� �������.
������� ������, ��� ��� ����� �������� ����� ���� ��������� ��������� (� ������ �������������),
����� ��� ������� ����� ������� ������ ���������� ��� ��������.
���������� �� ��������� ������ ���������� (�������������� ���� (���, ��������, �����),
�������������� � ������������� ����� ������� � �.�). ������� ������������ ������ ��� ������ ����������� �������� ����������� �����������.
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
