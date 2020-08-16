package main;

public class Pack01 {
    public static void main(String[] args) {
        findMaxValue(new int[]{2, 3, 4, 5, 9}, new int[]{3, 4, 5, 8, 10}, 20);//26
    }

    static int findMaxValue(int[] weights, int[] values, int capacity) {
        int[][] f = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j < weights[i-1]) {//将涉及weights、values的i全部换成i-1；即1在原始数组中实际上代表第0个元素
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - weights[i-1]] + values[i-1]);//将f[i - 1][j - weights[i-1]] + values[i-1]改为f[i][j - weights[i-1]] + values[i-1]则是完全背包
                }
            }
        }
        return f[values.length][capacity];
    }
}
