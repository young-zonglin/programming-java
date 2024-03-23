package yzl.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// TODO 3 使用双向队列deque
public class Solution_146_LRU缓存 {
    private final int capacity;

    private final Map<Integer, Integer> cache = new LinkedHashMap<>();

    public Solution_146_LRU缓存(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.remove(key);
            cache.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else {
            if (cache.size() >= this.capacity) {
                Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
                iterator.next();
                // 头部是最久的元素
                iterator.remove();
            }
        }
        // 放到尾部
        cache.put(key, value);
    }

    public static void main(String[] args) {
        Solution_146_LRU缓存 lruCache = new Solution_146_LRU缓存(2);
        lruCache.put(2, 1);
        lruCache.put(3, 2);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.put(4, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
