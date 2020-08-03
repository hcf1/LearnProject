package draft;
import java.util.*;
import java.util.HashSet;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class a {
    public static void main(String[] args) throws InterruptedException {
        //线程池、限制线程数量
        ExecutorService executor= Executors.newFixedThreadPool(5);
        executor.execute(()->{
            System.out.println("执行线程池里的线程");
        });
        //信号量，限制同时操作某一资源的线程数量
        Semaphore semaphore = new Semaphore(5);
        //类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //lambda表达式
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(a -> {
            System.out.println(a);
        });
        list.forEach(System.out::println);
        list.stream().collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
