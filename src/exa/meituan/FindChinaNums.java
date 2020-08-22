package exa.meituan;

import java.util.Scanner;

/**
 * 要求“CHINA”中五个字母要连续出现，方向可以是上、下、左、右中的任意一个。
 * 例如在下面的4*4的方阵中就包含了两个不同的“CHINA”。一个是第1行第1列到第3列的“CHI”，加上第2行第3列的“N”以及第2行第2列的“A”组成的“CHINA”；还有一个是第1行第1列到第3列的“CHI”，加上第2行第3列的“N”以及第3行第3列的“A”。
 * CHIA
 * CANT
 * GRAC
 * BBDE
 * 输入描述
 * 单组输入，每个测试样例包含N+1行。
 * 第1行为方阵的大小N（N<=30）。
 * 第2行到第N+1行用于存储由大写字母组成的方阵，每一行包含N个大写字母。
 * 输出描述
 * 输出方阵中包含的不同的CHINA的个数。如果一个都没有找到，则输出0。
 * 样例输入
 * 4
 * CHIA
 * CANT
 * GRAC
 * BBDE
 * 样例输出
 * 2
 */
public class FindChinaNums {
    static int[] target = new int[]{'C', 'H', 'I', 'N', 'A'};
    static int num = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int m = num;
        int n = num;
        char[][] list = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s=in.next();
            for (int j = 0; j < n; j++) {
                list[i][j] = s.toCharArray()[j];
            }
        }
//        findPath(new char[][]{{'C', 'H', 'I', 'A'}, {'C', 'A', 'N', 'T'}, {'G', 'R', 'A', 'C'},{'B', 'B', 'D', 'E'}});
        findPath(list);
    }

    static void findPath(char[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (list[i][j]==target[0]){
                    findCore(list, i, j, 0);
                }
            }
        }
        System.out.println(num);
    }

    private static void findCore(char[][] list, int i, int j, int result) {
        if (result == 4) {
            num++;
            return;
        }
        if (j + 1 < list[0].length && list[i][j + 1] == target[result + 1]) {
            findCore(list, i, j + 1, result + 1);
        }
        if (i + 1 < list.length && list[i + 1][j] == target[result + 1]) {
            findCore(list, i + 1, j, result + 1);
        }
        if (j - 1 >= 0 && list[i][j - 1] == target[result + 1]) {
            findCore(list, i, j - 1, result + 1);
        }
        if (i - 1 >= 0 && list[i - 1][j] == target[result + 1]) {
            findCore(list, i - 1, j, result + 1);
        }
    }
}