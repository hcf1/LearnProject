import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个单例类，不支持并发,普通懒汉
 *
 * @author hcf
 */
public class SingletonPattern {
    static private SingletonPattern singletonPat;

    private SingletonPattern() {
    }

    public static SingletonPattern getSingletonPat() {
        if (singletonPat == null) {
            singletonPat = new SingletonPattern();
            return singletonPat;
        }
        return singletonPat;
    }
}

/**
 * 支持并发创建，线程安全的懒汉，虽然线程安全，但是创建效率低
 **/
class SingletonPattern1 {
    static private SingletonPattern1 singletonPat;

    private SingletonPattern1() {

    }

    public static SingletonPattern1 getSingletonPat() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            if (singletonPat == null) {
                singletonPat = new SingletonPattern1();
                return singletonPat;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            return singletonPat;
        }
    }
}

/**
 * 普通饿汉模式，解决创建对象效率低的问题
 **/
class SingletonPattern2 {
    private static SingletonPattern2 singletonPat = new SingletonPattern2();

    private SingletonPattern2() {

    }

    static SingletonPattern2 getSingletonPat() {
        return singletonPat;
    }
}

/**
 * 按需创建的饿汉模式，解决过早创建实例，降低内存使用效率
 * 静态内部类被调用时才初始化
 **/
class SingletonPattern3 {
    static SingletonPattern3 getSingletonPat() {
        return GetInstance.singletonPat;
    }

    private static class GetInstance {
        static SingletonPattern3 singletonPat = new SingletonPattern3();
    }
}
/**
 * 懒汉线程安全——双重校验锁(先判断单例是否存在，缩小锁的范围)
 * **/
class SingletonPattern4{
    private static SingletonPattern4 singletonPat;

    private SingletonPattern4() {

    }

    public static SingletonPattern4 getSingletonPat() {
        ReentrantLock lock= new ReentrantLock();
        if (singletonPat == null) {
            //可能存在多个线程在此处等待锁
            lock.lock();
            try {
                //因此在获取锁后还需要再判断一次
                if (singletonPat == null) {
                    singletonPat = new SingletonPattern4();
                    return singletonPat;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                return singletonPat;
            }
        }else {
            return singletonPat;
        }
    }
}
