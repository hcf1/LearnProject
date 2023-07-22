package leetcode;

import java.util.HashMap;

/**
 * 整数替换
 */
public class N397 {
    public static void main(String[] args) {
        System.out.println(new N397().integerReplacement(9));
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 暴力递归，优化时间
     */
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result;
            if (n % 2 == 0) {
                result = 1 + integerReplacement(n / 2);

            } else {
                result = 2 + Math.min(integerReplacement(n / 2 + 1), integerReplacement((n - 1) / 2));
            }
            map.put(n, result);
            return result;
        }
    }

    /**
     * 贪心算法，分偶数和奇数；奇数分为：%4为1取 (n-1)/2 -> n/2; 为3 取 (n+1)/2 ->n/2+1
     */
    public int integerReplacement1(int n) {
        int step = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                step++;
                n /= 2;
            } else {
                if (n == 3) {
                    return step + 2;
                }
                if (n % 4 == 1) {
                    step += 2;
                    n = n / 2;
                } else {
                    step += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return step;
    }
}
