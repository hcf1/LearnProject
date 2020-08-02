package exa;

import java.util.Scanner;

public class Pinduoduo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int delicious = in.nextInt();
        int list1[][] = new int[n1][2];
        int list2[][] = new int[n2][2];
        int i = 0;
        while (in.hasNextInt()) {
            list1[i][0] = in.nextInt();
            list1[i][1] = in.nextInt();
            i++;
            if (i == n1) {
                break;
            }
        }
        i = 0;
        while (in.hasNextInt()) {
            list2[i][0] = in.nextInt();
            list2[i][1] = in.nextInt();
            i++;
            if (i == n2) {
                break;
            }
        }
        findMin(list1, list2, delicious);
    }

    static void findMin(int[][] list1, int[][] list2, int delicious) {
        if (delicious == 0) {
            System.out.println(0);
            return;
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min = 0;
        for (int[] list11 : list1) {
            if (list11[1] >= delicious && list11[0] < min1) {//美味值满足
                min1 = list11[0];
            }
        }
        for (int[] list22 : list2) {
            if (list22[1] >= delicious && list22[0] < min2) {//美味值满足
                min2 = list22[0];
            }
        }
        min = Math.min(min1, min2);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
    }
}
