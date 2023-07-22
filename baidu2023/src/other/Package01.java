package other;

/**
 * 01背包问题
 */
public class Package01 {
    int V;
    int N;
    int[] weight;
    int[] value;

    public static void main(String[] args) {
        /**
         * 物品种类 4
         * 重量 2 3 4 5
         * 价值 3 4 5 6
         * 容量 8
         * 背包内最大的物品价值总和为：10
         * 包内物品的编号为：2 4
         */
        System.out.println(new Package01().zeroOnePack1(10, 4, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
    }

    /**
     * 暴力递归法，由上至下
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量wight
     * @param value  物品价值value
     */
    public int zeroOnePack(int V, int N, int[] weight, int[] value) {
        this.V = V;
        this.N = N;
        this.weight = weight;
        this.value = value;
        return findMaxValue(0, V, 0);
    }

    public int findMaxValue(int goodsIndex, int currentV, int currentValue) {
        if (goodsIndex == N) {
            return currentValue;
        }
        if (currentV < weight[goodsIndex]) {
            return currentValue;
        }
        return Math.max(
                findMaxValue(goodsIndex + 1, currentV - weight[goodsIndex], currentValue + value[goodsIndex]),
                findMaxValue(goodsIndex + 1, currentV, currentValue)
        );
    }

    /**
     * 动态规划，由下至上
     */
    public int zeroOnePack1(int V, int N, int[] weight, int[] value) {
        this.V = V;
        this.N = N;
        this.weight = weight;
        this.value = value;
        int[][] result = new int[N + 1][V + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                if (j - weight[i - 1] < 0) {
                    result[i][j] = result[i - 1][j];
                    continue;
                }
                result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - weight[i - 1]] + value[i - 1]);
            }
        }
        return result[N][V];
    }
}
