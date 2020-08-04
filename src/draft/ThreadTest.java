package draft;

/**
 * @author hasee
 */
public class ThreadTest {
    private boolean a = false;
    private boolean isPause = false;

    void runTreadTest() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (isPause) {
                        break;
                    }
                    System.out.println(a);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
//        ThreadLocal
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest thread = new ThreadTest();
        thread.runTreadTest();
        Thread.sleep(3000);
        thread.a = true;
        thread.isPause = true;
    }
}
