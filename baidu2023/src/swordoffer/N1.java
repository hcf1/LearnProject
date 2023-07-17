package swordoffer;

/**
 * 整数除法
 */
public class N1 {
    public static void main(String[] args) {
        System.out.println(divide(15, -2));
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MIN_VALUE;
        }
        boolean isPositive = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            return 0;
        }
        int divide = 1;
        while (b <= a) {
            // 倍数
            int value = 1;
            // 当前大小
            int n = b;
            while (n <= a) {
                value <<= 1;
                n <<= 1;
            }
            value >>= 1;
            n >>= 1;
            a -= n;
            divide += value;
        }
        if (isPositive) {
            return divide - 1;
        }
        return -(divide - 1);
    }
}
