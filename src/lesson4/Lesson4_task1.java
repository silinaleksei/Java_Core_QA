package lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* Задание 1.
   Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
   Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
   Посчитать, сколько раз встречается каждое слово.
    */
public class Lesson4_task1 {
    public static ArrayList<String> wordList;

    public static void main(String[] args) {
        String[] wordsArray = {"Lorem", "ipsum", "dolor", "sit", "amet", "sit", "ipsum", "inventory", "consequent", "ipsum"};
        wordList = new ArrayList<>(Arrays.asList(wordsArray));
        // Sorting unique array values using the HashSet constructor
        HashSet<String> uniqueList = new HashSet<>(Arrays.asList(wordsArray));
        System.out.println(uniqueList); // [dolor, Lorem, amet, ipsum, consequent, inventory, sit]

        // Sorting unique array values using a foreach loop
//        for (String s: wordList) {
//            uniqueList.add(s);}

        // Count how many times each word occurs
        HashMap<String, Integer> result = new HashMap<>();

        for (String str : wordList) {
            result.put("Word " + "'" + str + "'", count(str));
        }
        System.out.println(result); // {Word 'dolor'=1, Word 'Lorem'=1, Word 'amet'=1, Word 'sit'=2, Word 'consequent'=1, Word 'ipsum'=3, Word 'inventory'=1}
    }

    public static Integer count(String string) {
        Integer result = 0;
        for (String str : wordList) {
            if (str.equals(string)) result++;
        }
        return result;
    }
}
