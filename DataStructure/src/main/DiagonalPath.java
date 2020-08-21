package main;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
 * 示例
 * 输入:
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * 思路
 * 判断矩阵是否为空 为空，则返回空数组
 * 创建一个长度为row*col的数组
 * 将矩阵中对应坐标的数字填充入数组
 * <p>
 * 判断(row+col)的奇和偶 奇数向下走r++，c-- 偶数向上走r–，c++
 */
public class DiagonalPath {
    public static void main(String[] args) {
        findPath(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    static void findPath(int[][] list) {
        if (list == null || list.length == 0) {
            return;
        }
        int row = 0;
        int col = 0;
        while (row < list.length && col < list[0].length) {
            if ((row + col) % 2 == 0) {//偶数层向上
                while (row >= 0 && col < list[0].length) {
                    System.out.println(list[row][col]);
                    row--;
                    col++;
                }
                row++;
                col--;
                if (col < list[0].length - 1) {//还能向右走一步
                    col++;
                } else {//向下走一步
                    row++;
                }
            } else {
                while (row < list.length && col >= 0) {
                    System.out.println(list[row][col]);//奇数层向下
                    row++;
                    col--;
                }
                row--;
                col++;
                if (row + 1 < list.length) {
                    row++;
                } else {
                    col++;
                }
            }
        }
    }
}
