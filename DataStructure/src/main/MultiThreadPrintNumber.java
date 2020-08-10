package main;

public class MultiThreadPrintNumber {
    private volatile int i = 0;
    private volatile int flag = 1;
    public static void main(String[] args) {
        MultiThreadPrintNumber multiThreadPrintNumber = new MultiThreadPrintNumber();
        multiThreadPrintNumber.printNumber();
    }

    void printNumber() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 19) {
                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName()+i);
                        i++;
                        flag = 2;
                    }
                }
            }
        },"1线程：").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 20) {
                    if (flag == 2) {
                        System.out.println(Thread.currentThread().getName()+i);
                        i++;
                        flag = 3;
                    }
                }
            }
        },"2线程：").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 21) {
                    if (flag == 3) {
                        System.out.println(Thread.currentThread().getName()+i);
                        i++;
                        flag = 1;
                    }
                }
            }
        },"3线程：").start();
    }
}
