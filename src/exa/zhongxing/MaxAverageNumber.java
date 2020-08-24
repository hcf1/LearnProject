package exa.zhongxing;

/**
 * 求一组数字中的最大平均数
 * 输入
 * 9
 * 3 5 3 7 7 6 6 5 6
 * 输出
 * 7
 * 以下是动态规划解法
 * 智力测试题！直接输出最大数不就ok了？非要用动态规划？
 */
public class MaxAverageNumber {
    public static void main(String[] args) {
        findMax(new int[]{3,5,3,7,7,6,6,5,6});
    }

    static void findMax(int[] list) {
        int[][] dp = new int[list.length + 1][list.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            dp[i][i] = list[i];
        }
        for (int i = 1; i <= list.length; i++) {
            for (int j = i; j <= list.length; j++) {
                dp[i][j] = Math.max((dp[i][j - 1]*(j-i)+list[j-1])/(j-i+1), dp[i][j]);
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
