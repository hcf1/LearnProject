import java.util.HashMap;

/**
 * 求斐波那契数列的第n项
 *
 * @author hasee
 */
public class Fibonacci {
    /**
     * 使用简单递归的方式求第n项，缺点是会重复计算f(n),时间复杂度为O(2**n)，空间复杂度为O(n)
     */
    static class Fibonacci1 {
        Integer f(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n > 1) {
                return f(n - 1) + f(n - 2);
            }
            return null;
        }
    }

    /**
     * 使用map来存储计算过的值，避免重复计算,时间复杂度为O(n)，空间复杂度为O(n)
     */
    static class Fibonacci2 {
        Integer f(int n) {
            HashMap<Integer, Integer> map = new HashMap<>();
            if (n < 0) {
                return null;
            }
            map.put(0, 0);
            map.put(1, 1);
            for (int i = 2; i <= n; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }
            return map.get(n);
        }
    }
    /**
     * 直接计算，将前两个数的值赋值给后一个（a=0,b=1,c=a+b;a=b,b=c,c=a+b;...），避免重复计算,时间复杂度为O(n)，空间复杂度为O(1)
     */
    static class Fibonacci3 {
        Integer f(int n) {
            if (n < 0) {
                return null;
            }
            if (n == 0 || n == 1) {
                return n;
            }
            int a=0,b=1,c = 0;
            for (int i = 2; i <= n; i++) {
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }
    }
}
/**
 * 一只青蛙可以跳上1级和2级台阶，求它跳上n级台阶共有多少种跳法
 * 思路：青蛙可以有两种跳法，如果跳了1个台阶，那么还剩n-1个，如果跳了2个，还剩n-2个
 * 所以有f(n)=f(n-1)+f(n-2)
 * 如果青蛙有n种跳法，那么有：f(n)=f(n-1)+f(n-2)+...+f(1)+1=2**(n-1)
 * */
class FrogJump {
    static Integer countNums(int n) {
        if (n < 0) {
            return null;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int a=1, b=2, c=0;
        for (int i = 3; i <= n; ++i) {
            c=a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
