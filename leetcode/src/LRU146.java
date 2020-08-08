import java.util.LinkedHashMap;

public class LRU146 {
    int initCapacity;
    LinkedHashMap<Integer, Integer> lruCache;

    LRU146(int initCapacity) {
        this.initCapacity = initCapacity;
        this.lruCache = new LinkedHashMap<>(initCapacity);
    }

    public static void main(String[] args) {
        LRU146 cache = new LRU146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));      // 返回  4
    }

    public void put(int key, int value) {
        lruCache.put(key, value);
        lruCache.put(key, lruCache.remove(key));//如果已经存在了，则取出来重现添加到队尾，队尾是最近访问的
        if (lruCache.size() > initCapacity) {
            int oldKey = lruCache.keySet().iterator().next();//取出队头删除
            lruCache.remove(oldKey);
        }
    }

    public int get(int key) {
        if (lruCache.containsKey(key)) {
            lruCache.put(key, lruCache.remove(key));
            return lruCache.get(key);
        } else return -1;
    }
}
