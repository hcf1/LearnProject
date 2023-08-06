package other;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 两个线程交替打印AB
 */
public class MultiThreadPrintAB {
    AtomicBoolean shouldPrintA = new AtomicBoolean(true);
    final Object o = new Object();

    Thread A = new Thread(() -> printAB(), "A");

    Thread B = new Thread(() -> printAB(), "B");

    public static void main(String[] args) {

        new MultiThreadPrintAB().start();
    }

    public void start() {
        A.start();
        B.start();
    }

    public void stop() {
        A.interrupt();
        B.interrupt();
    }

    /**
     * 自旋锁
     */
    public void printAB() {
        while (true) {
            if (shouldPrintA.get()) {
                if (Thread.currentThread().getName().equals("B")) {
                    continue;
                }
                System.out.println(Thread.currentThread().getName() + "A");
                shouldPrintA.set(false);
            } else {
                if (Thread.currentThread().getName().equals("A")) {
                    continue;
                }
                System.out.println(Thread.currentThread().getName() + "B");
                shouldPrintA.set(true);
            }
        }
    }

    /**
     * 锁对象
     */
    public void printAB1() {
        while (true) {
            synchronized (o){
                if (shouldPrintA.get()) {
                    System.out.println(Thread.currentThread().getName() + "A");
                    shouldPrintA.set(false);
                } else {
                    System.out.println(Thread.currentThread().getName() + "B");
                    shouldPrintA.set(true);
                }
            }
        }
    }
}
