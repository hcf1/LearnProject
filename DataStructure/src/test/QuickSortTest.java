package test;

import main.QuickSortSimple;
import main.QuickSortSimple1;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] list = new int[]{6, 4, 2, 7, 8, 9, 1};
        QuickSortSimple1.sortWrap(list);
        for (int i : list) {
            System.out.printf(String.valueOf(i));
        }
    }
}
