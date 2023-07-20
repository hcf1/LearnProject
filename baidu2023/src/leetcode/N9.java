package leetcode;

import java.util.LinkedList;

/**
 * 回文数
 */
public class N9 {
    public static void main(String[] args) {
        System.out.println(new N9().isPalindrome1(1000000001));
    }

    /**
     * 转换成字符串，时间O(logn)、空间O(logn)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        LinkedList<Integer> result = new LinkedList<>();
        // 除数
        long num = 10;
        while (x != 0) {
            // 余数
            int n1 = (int) (x % num);
            result.add((int) (n1 / (num / 10)));
            x -= n1;
            num *= 10;
        }
        int l = result.size();
        int left = 0;
        int right = l - 1;
        while (left < right) {
            if (result.get(left) != result.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 转换数字，时间O(logn)、空间O(1)
     */
    public boolean isPalindrome1(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int x2 = 0;
        while (x2 < x) {
            // 余数
            int n1 = x % 10;
            x2 = x2 * 10 + n1;
            x /= 10;
        }
        if (x == x2) {
            return true;
        } else {
            return x2 / 10 == x;
        }
    }
}
