public class SingletonPatternTest {
    public static void main(String[] args) {
        SingletonPatternTest test = new SingletonPatternTest();
        test.threadTest();
//        test.test();
    }
/*单线程测试单例类*/
    void test() {
        SingletonPattern3 singletonPattern1 = SingletonPattern3.getSingletonPat();
        SingletonPattern3 singletonPattern2 = SingletonPattern3.getSingletonPat();
        System.out.println(singletonPattern1.toString() + "\n" + singletonPattern2.toString());
    }
/*多线程测试单例类*/
    void threadTest() {
        Test test= new Test();
        for (int i = 0; i < 10; i++) {
            new Thread(test,Integer.toString(i)).start();
        }
    }
    static class Test implements Runnable{

        public void run() {
            System.out.println(SingletonPattern4.getSingletonPat().toString()+"线程"+Thread.currentThread().getName());
        }
    }
}
