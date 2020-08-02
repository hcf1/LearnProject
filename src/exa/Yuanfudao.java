package exa;

import java.util.Scanner;

public class Yuanfudao {
    public static void main(String[] args) {
        int rows = 0;
        Scanner in = new Scanner(System.in);
        rows = in.nextInt();
        int[][] list = new int[rows][2];
        int i = 0;
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            list[i][0] = a;
            list[i][1] = b;
            i++;
            if (i == rows) {
                break;
            }
        }
        findHearts(list);
    }

    static void findHearts(int[][] list) {
        int hearts = 0, left = list[0][0], right = 0;
        for (int[] time : list) {
            if (time[0] < left) {
                left = time[0];
            }
            if (time[1] > right) {
                right = time[1];
            }
        }
        for (; left < right; left++) {
            int count = 0;
            for (int[] time : list) {
                if (time[0] <= left && left < time[1]) {
                    count++;
                }
            }

            if (count > hearts) {
                hearts = count;
            }
        }
        System.out.println(hearts);
    }
}
