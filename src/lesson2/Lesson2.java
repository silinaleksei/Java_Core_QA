package lesson2;

public class Lesson2 {
    public static void main(String[] args) {

        String[][] stringArray = new String[4][4];
        fillArray(stringArray); // заполняем массив
        printArray(stringArray); // выводим в консоль
        try { // Sum array: 440
            System.out.println("Sum array: " + sumArray(stringArray));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        String[][] stringArray4x3 = new String[4][3]; // массив с неправильным размером
        try { // Wrong array size
            System.out.println("Sum array: " + sumArray(stringArray4x3));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        stringArray[3][2] = "abc"; // меняем значение элемента [3][2] на строку "abc"
        printArray(stringArray);
        try { // Wrong data format in row 4, column 3
            System.out.println("Sum array: " + sumArray(stringArray));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void stringExceptionTest(String[][] array) throws MyArraySizeException {
        if (array.length != 4) throw new MyArraySizeException("Wrong array size");
        for (String[] strings : array) {
            if (strings.length != 4) throw new MyArraySizeException("Wrong array size");
        }
    }

    public static int sumArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        stringExceptionTest(array);
        int i = 0;
        int j = 0;
        int sum = 0;
        try {
            for (; i < array.length; i++) {
                j = 0;
                for (; j < array[i].length; j++) {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Wrong data format in row " + (i + 1) + ", column " + (j + 1));

        }
        return sum;
    }

    public static void fillArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "" + (i + 1) + (j + 1);
            }
        }
    }

    public static void printArray(String[][] array) {
        for (String[] strings : array) {
            System.out.print("[");
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
