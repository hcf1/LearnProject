class FibonacciTest {
    public static void main(String[] args) {
        Fibonacci.Fibonacci1 fibonacii = new Fibonacci.Fibonacci1();
        System.out.println(fibonacii.f(10));
        Fibonacci.Fibonacci2 fibonacii2 = new Fibonacci.Fibonacci2();
        System.out.println(fibonacii2.f(10));
        Fibonacci.Fibonacci22 fibonacii22 = new Fibonacci.Fibonacci22();
        System.out.println(fibonacii22.findNum(10));
        Fibonacci.Fibonacci3 fibonacii3 = new Fibonacci.Fibonacci3();
        System.out.println(fibonacii3.f(10));
        Fibonacci.Fibonacci33 fibonacii33 = new Fibonacci.Fibonacci33();
        System.out.println(fibonacii33.findNum(10));
        System.out.println("以下是青蛙跳！");
        System.out.println(FrogJump.countNums(4));
    }
}