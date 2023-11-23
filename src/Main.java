import practice.SelectionSort;
import practice.TreeMap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TreeMap<String, String> tree = new TreeMap<>();

        SelectionSort ss = new SelectionSort();
        int[] intArr = { 7, 3, 2, 8, 9, 4, 4, 4, 6, 1, 5};
        int[] sortedArr = ss.selectionSort(intArr);
    System.out.println(Arrays.toString(sortedArr));

    }
}