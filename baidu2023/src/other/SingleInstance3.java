package other;

/**
 * 双重校验
 */
public class SingleInstance3 {
    private static volatile SingleInstance3 singleInstance3;

    private SingleInstance3() {
    }

    public static SingleInstance3 getSingleInstance3() {
        if (singleInstance3 == null) {
            synchronized (SingleInstance3.class) {
                if (singleInstance3 == null) {
                    singleInstance3 = new SingleInstance3();// 开辟内存空间 初始化对象 引用指向内存空间
                }
            }
        }
        return singleInstance3;
    }
}
