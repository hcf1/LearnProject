/**
 * 给你一根长度为 n 的绳子，请把绳子减成 m 段（m、n都是整数，n > 1 并且 m >1）,每段绳子的长度记为k[0], k[1],...,k[m]。
 * 请问k[0]*k[1]*k[2]*...*k[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成的长度为2、3、3三段，此时得到的最大乘积是18。
 *
 * @author hasee
 * 思路一：使用动态规划，因为此问题满足动态规划的4个条件：1.最优化问题 2.整体最优解依赖各子问题的最优解 3.有重复子问题 4.可以从上向下
 * 分析，从下向上求解。
 * 思路二：使用贪婪算法，使用贪婪策略：当长度大于等于5时，尽可能多的将绳子截成长度为3的绳子（当剩下的绳子是4时不截成3和1，直接返回4）
 */
public class CutRopeByDynamicProgramming {
    int findMaxByDP(int n) {
        if (n < 2) {
            return -1;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        int k = 4;
        while (k <= n) {
            int max = 0;
            for (int j = 1; j <= k / 2; j++) {
                max = Math.max(result[j] * result[k - j], max);
            }
            result[k] = max;
            k++;
        }
        return result[n];
    }

    int findMaxByGA(int n) {
        if (n < 2) {
            return -1;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        result[4] = 4;
        int k = 5;
        while (k <= n) {
            int remainder = k % 3;
            int quotient = k / 3;
            if (remainder == 0) {
                result[k] = (int) Math.pow(3,quotient);
            } else if (remainder == 1) {
                result[k] = (int) Math.pow(3,quotient-1)* 4;
            } else if (remainder == 2) {
                result[k] = (int) Math.pow(3,quotient) * 2;
            }
            k++;
        }
        return result[n];
    }
}
