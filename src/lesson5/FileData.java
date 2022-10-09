package lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 1. Реализовать сохранение данных в csv файл;
//2. Реализовать загрузку данных из csv файла. Файл читается целиком.
// Структура csv файла:
//Строка заголовок с набором столбцов                                                                                                                                                   Набор строк с целочисленными значениями
// * Разделитель между столбцами - символ точка с запятой (;)
//Пример:
// Value 1;Value 2;Value 3
// 100;200;123
// 300,400,500

public class FileData {
    public static ArrayList<TableData> tableDataArrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        createTableData(); // заполняем эрейлист данными
        //System.out.println(tableDataArrayList); // [TableData{Value1=1, Value2=10, Value3=100}, TableData{Value1=2, Value2=20, Value3=200}, TableData{Value1=3, Value2=30, Value3=300}, TableData{Value1=4, Value2=40, Value3=400}, TableData{Value1=5, Value2=50, Value3=500}]
        writer();
        AppData appData = downloadDataFromFile();
        System.out.println(appData); // AppData{header=[value1, value2, value3], data=[[1, 10, 100], [2, 20, 200], [3, 30, 300], [4, 40, 400], [5, 50, 500]]}
    }

    // метод заполнения эрейлиста tableDataArrayList данными
    public static void createTableData() {
        for (int i = 1; i <= 5; i++) {
            tableDataArrayList.add(new TableData(i, i * 10, i * 100));
        }
    }

    // метод записи в файл file.csv заголовка и данных из таблицы (эрейлиста tableDataArrayList)
    public static void writer() throws IOException {
        try (FileWriter writer = new FileWriter("src/lesson5/file.csv")) {
            writer.write("value1" + ";" + "value2"
                    + ";" + "value3" + ";" + System.getProperty("line.separator"));
            for (TableData tableData : tableDataArrayList) {
                writer.write(tableData.getValue1() + ";" + tableData.getValue2()
                        + ";" + tableData.getValue3() + ";" + System.getProperty("line.separator"));
            }
        }
    }

    // метод загрузки данных из файла file.csv в объект appData класса AppData
    public static AppData downloadDataFromFile() throws IOException {
        AppData appData = new AppData();
        List<List<String>> arrayListData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/lesson5/file.csv"))) {
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                arrayListData.add(Arrays.asList(values));
            }
        }
        int[][] data = new int[arrayListData.size()][3];
        for (int i = 0; i < arrayListData.size(); i++) {
            for (int j = 0; j < arrayListData.get(i).size(); j++) {
                data[i][j] = Integer.parseInt(arrayListData.get(i).get(j));
            }
        }
        appData.setData(data);
        return appData;
    }
}