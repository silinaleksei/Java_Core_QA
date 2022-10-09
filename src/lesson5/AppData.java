package lesson5;

import java.util.Arrays;
// ��� �������� ������ ������������ ����� ����
// public class AppData {
//private String[] header;
// private int[][] data;
//// ... }
public class AppData {
    private String[] header;
    private int[][] data;

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" +  Arrays.deepToString(data) +
                '}';
    }

}
