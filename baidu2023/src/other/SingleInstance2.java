package other;

/**
 * 饿汉
 */
public class SingleInstance2 {
    private static SingleInstance2 singleInstance2 = new SingleInstance2();

    private SingleInstance2() {
    }

    public static SingleInstance2 getInstance() {
        return singleInstance2;
    }
}
