package exa.aiqiyi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 在一个电路板上一些位置上已经固定了一些元器件，现在选择一个地方放置主芯片，每个元件都要和芯片单线连接上，
 * 要求所有元器件的连接主芯片时总路径最短，求主芯片的位置和最短的路径总距离？
 * 条件：电路板上连线的时候只能走直线，可以90度拐弯（可以想象电路板是一种井字格排布的），
 * 路径可以交叉（可以想象为交叉的线在不同的层），元器件可以和芯片在同一位置。,假设芯片的坐标位置为整数int表示，例如（4，-3）
 * <p>
 * 输入描述
 * 元器件个数，元器件的坐标位置
 * <p>
 * 输出描述
 * 芯片坐标和最短连线总距离
 * <p>
 * 样例输入
 * 5
 * 1 2
 * 2 2
 * 1 3
 * 3 -2
 * 3 3
 * 样例输出
 * 2 2 10
 * 暴力时间超时 过66%
 */
public class ShortestPath {
    static HashMap<int[], Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        if (row <= 0) {
            System.out.println("0");
            return;
        }
        int[][] target = new int[row][2];
        int i = 0;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            maxX = Math.max(a, maxX);
            maxY = Math.max(b, maxY);
            minX = Math.min(a, minX);
            minY = Math.min(b, minY);
            target[i][0] = a;
            target[i][1] = b;
            i++;
            if (i == row) {
                break;
            }
        }
        int[] leftTop = new int[]{minX, minY};
        int[] rightBottom = new int[]{maxX, maxY};
        for (int k : findShortPath(leftTop, rightBottom, target)) {
            System.out.printf("%d ", k);
        }
        System.out.println("");
//        System.out.println(findShortPath(new int[]{1, -2}, new int[]{3, 3}, new int[][]{{1, 2}, {2, 2}, {1, 3}, {3, -2}, {3, 3}}));
    }

    static int[] findShortPath(int[] leftTop, int[] rightBottom, int[][] target) {
        int min = Integer.MAX_VALUE;
        int[] result = new int[3];
        for (int i = leftTop[0]; i <= rightBottom[0]; i++) {
            for (int j = leftTop[1]; j <= rightBottom[1]; j++) {
                if (findPath(target, i, j) < min) {
                    result[0] = i;
                    result[1] = j;
                    min = findPath(target, i, j);
                }
            }
        }
        result[2] = min;
        return result;
    }

    private static int findPath(int[][] target, int i, int j) {
        int distance = 0;
        int one = 0;
        for (int[] pos : target) {
            if (hashMap.containsKey(new int[]{pos[0], pos[1], i, j})) {
                distance += hashMap.get(new int[]{pos[0], pos[1], i, j});
            }
            if (i > pos[0]) {
                distance += (i - pos[0]);
            } else {
                distance += (pos[0] - i);
            }
            if (j > pos[1]) {
                distance += (j - pos[1]);
            } else {
                distance += (pos[1] - j);
            }
            hashMap.put(new int[]{pos[0], pos[1], i, j}, one);
            distance += one;
            one = 0;
        }
        return distance;
    }
}
