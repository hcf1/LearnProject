package other;

/**
 * 青蛙跳台 f(n)=f(n-1)+f(n-2)
 */
public class FrogJump {
    public static void main(String[] args) {

    }

    /**
     * @param n n个台阶
     * @return 多少种跳法
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 0;
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            result = (a + b) % 1000000007;
            a = b;
            b = result;
        }
        return result % 1000000007;
    }
}
