public class Fibonacci1 {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    static int fibonacci(int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 0 || target == 1) {
            return target;
        }
        if (target == 2) {
            return 2;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
