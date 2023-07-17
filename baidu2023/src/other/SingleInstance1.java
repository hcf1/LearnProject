package other;

/**
 * 懒汉
 */
public class SingleInstance1 {
    private static SingleInstance1 singleInstance;

    private SingleInstance1() {
    }

    public static synchronized SingleInstance1 getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new SingleInstance1();
        }
        return singleInstance;
    }
}
