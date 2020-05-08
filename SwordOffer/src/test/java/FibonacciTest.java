class FibonacciTest {
    public static void main(String[] args) {
        Fibonacci.Fibonacci1 fibonacii = new Fibonacci.Fibonacci1();
        System.out.println(fibonacii.f(10));
        Fibonacci.Fibonacci2 fibonacii2 = new Fibonacci.Fibonacci2();
        System.out.println(fibonacii2.f(10));
        Fibonacci.Fibonacci3 fibonacii3 = new Fibonacci.Fibonacci3();
        System.out.println(fibonacii3.f(10));
        System.out.println("以下是青蛙跳！");
        System.out.println(FrogJump.countNums(4));
    }
}