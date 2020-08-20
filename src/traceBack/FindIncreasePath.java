package traceBack;

import java.util.Scanner;

/**
 * AC!!!!!
 * 寻找最大上升路径
 * <p>
 * 输入
 * 3 3
 * 9 1 4
 * 6 2 8
 * 5 5 7
 * 输出
 * 5
 * 路径
 * 1、2、5、7、8
 */
public class FindIncreasePath {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] list = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                list[i][j] = in.nextInt();
            }
        }
        findPath(list);
    }

    static void findPath(int[][] list) {
        int result = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                max = Math.max(max, findCore(list, i, j, result));
            }
        }
        System.out.println(max);
    }

    private static int findCore(int[][] list, int i, int j, int result) {
        int a=0, b=0, c=0, d=0;
        if (j + 1 < list[0].length && list[i][j + 1] > list[i][j]) {
            a = findCore(list, i, j + 1, result + 1);
        }
        if (i + 1 < list.length && list[i + 1][j] > list[i][j]) {
            b = findCore(list, i + 1, j, result + 1);
        }
        if (j - 1 >= 0 && list[i][j - 1] > list[i][j]) {
            c = findCore(list, i, j - 1, result + 1);
        }
        if (i - 1 >= 0 && list[i - 1][j] > list[i][j]) {
            d = findCore(list, i - 1, j, result + 1);
        }
        result = Math.max(a, Math.max(b, Math.max(c, Math.max(d,result))));
        return result;
    }
}
