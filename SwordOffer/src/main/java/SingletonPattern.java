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

//手写双重校验到懒汉单例
class SingleInstance {
    private volatile static SingleInstance singleInstance;//指令重排，拿到半成品对象。可见性，线程工作内存创建的对象没有及时刷新到主存

    private SingleInstance() {

    }

    public static SingleInstance getSingleInstance() {
        if (singleInstance == null) {
            synchronized (SingleInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
}
/**
 * volatile
 * 禁止指令重排序。
 * 我们知道new Singleton()是一个非原子操作，编译器可能会重排序【构造函数可能在整个对象初始化完成前执行完毕，
 * 即赋值操作（只是在内存中开辟一片存储区域后直接返回内存的引用）在初始化对象前完成】。
 * 而线程B在线程A赋值完时判断instance就不为null了，此时B拿到的将是一个没有初始化完成的半成品。
 * 正常顺序是1、开辟内存空间2、初始化实例3、将变量指向对象。
 * <p>
 * 保证可见性。
 * 线程A在自己的工作线程内创建了实例，但此时还未同步到主存中；此时线程B在主存中判断instance还是null，
 * 那么线程B又将在自己的工作线程中创建一个实例，这样就创建了多个实例。
 */

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
 **/
class SingletonPattern4 {
    private static SingletonPattern4 singletonPat;

    private SingletonPattern4() {

    }

    public static SingletonPattern4 getSingletonPat() {
        ReentrantLock lock = new ReentrantLock();
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
            } finally {
                lock.unlock();
                return singletonPat;
            }
        } else {
            return singletonPat;
        }
    }
}
