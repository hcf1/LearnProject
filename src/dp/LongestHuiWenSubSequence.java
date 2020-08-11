package dp;

/**
 * 最长回文子序列
 */
public class LongestHuiWenSubSequence {
    public static void main(String[] args) {
        findSubSequence(new int[]{1, 2, 3, 3, 2, 2});
    }

    static void findSubSequence(int[] list) {
        int n = list.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {//对角线上初始化为1
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n + 1; j++) {
                if (list[i - 1] == list[j - 1]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
