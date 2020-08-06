package exa;

import java.util.Scanner;

public class LongestSubSequence {
    public static void main(String[] args) {
        initData();

    }

    static private void initData() {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        char[] list1 = new char[length];
        char[] list2 = new char[length];
        int i = 0;
        while (in.hasNext()) {
            list1[i] = in.next().charAt(0);
            i++;
            if (i == length) {
                break;
            }
        }
        i = 0;
        while (in.hasNext()) {
            list2[i] = in.next().charAt(0);
            i++;
            if (i == length) {
                break;
            }
        }

        float sum = findSequence(list1, list2);
        float result = sum / length;
        if (result <= 0.5) {
            System.out.printf("%.2f %s", result, "Yes");
        } else {
            System.out.println("No");
        }
    }

    static int findSequence(char[] list1, char[] list2) {
        int[][] f = new int[list1.length + 1][list2.length + 1];//f[i][j]表示长度为i的list1和长度为j的list2的最长公共子序列的长度
        for (int i = 1; i <= list1.length; i++) {
            for (int j = 1; j <= list1.length; j++) {
                if (list1[i - 1] == list2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], Math.max(f[i][j - 1], f[i - 1][j - 1]));
                }
            }
        }
        return f[list1.length][list2.length];
    }
}
