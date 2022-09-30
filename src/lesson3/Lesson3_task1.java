package lesson3;

import java.util.Arrays;

// 1. Написать метод, который меняет два элемента массива местами
// (массив может быть любого ссылочного типа);
public class Lesson3_task1 {
    public static void main(String[] args) {
        // without generics
        Integer[] arrayInt = {1,2,3,4,5};
        System.out.println(Arrays.toString(swapArrayElements(arrayInt,0,4)));
        Double[] arrayDbl = {1d,2d,3d,4d,5d};
        System.out.println(Arrays.toString(swapArrayElements(arrayDbl,0,4)));
        String[] arrayStr = {"1","2","3","4","5"};
        System.out.println(Arrays.toString(swapArrayElements(arrayStr,0,4)));
        Array[] arrayArr = {new Array(1), new Array(2), new Array(3), new Array(4), new Array(5)};
        System.out.println(Arrays.toString(swapArrayElements(arrayArr,0,4)));
        //System.out.println(Arrays.toString(swapArrayElements(arrayInt,0, 5))); // ArrayIndexOutOfBoundsException: Wrong element's index, array not changed
        System.out.println("*******************************************");
        // with generics
        Integer[] arrayInt2 = {1,2,3,4,5};
        Double[] arrayDbl2 = {1d,2d,3d,4d,5d};
        String[] arrayStr2 = {"1","2","3","4","5"};
        Array[] arrayArr2 = {new Array(1), new Array(2), new Array(3), new Array(4), new Array(5)};
        System.out.println(Arrays.toString(swapArrayElements2(arrayInt2,0,4)));
        System.out.println(Arrays.toString(swapArrayElements2(arrayDbl2,0,4)));
        System.out.println(Arrays.toString(swapArrayElements2(arrayStr2,0,4)));
        System.out.println(Arrays.toString(swapArrayElements2(arrayArr2,0,4)));
        //System.out.println(Arrays.toString(swapArrayElements2(arrayInt2,0, 5))); // ArrayIndexOutOfBoundsException: Wrong element's index, array not changed

    }
    // // without generics
    public static Object[] swapArrayElements (Object[] array, int ind1, int ind2) {
        Object temp;
        if(ind1 >=0 && ind1 <array.length && ind2 >=0 && ind2 <array.length) {
            temp = array[ind1];
            array[ind1] = array[ind2];
            array[ind2] = temp;
        } else {throw new ArrayIndexOutOfBoundsException("Wrong element's index! Array not changed");}
        return array;
    }
    // with generics
    public static <T> T[] swapArrayElements2 (T[] array,int ind1, int ind2) {
        T temp;
        if(ind1 >=0 && ind1 <array.length && ind2 >=0 && ind2 <array.length) {
            temp = array[ind1];
            array[ind1] = array[ind2];
            array[ind2] = temp;
        } else {throw new ArrayIndexOutOfBoundsException("Wrong element's index! Array not changed");}
        return array;
    }

    static class Array {
        int num;
        public Array(int num) {
            this.num = num;
        }
        @Override
        public String toString() {
            return "Array{" + num +'}';
        }
    }
}
