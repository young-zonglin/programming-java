package yzl.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_146_LRU缓存 {
    static class Node {
        int val;
        Node before;
        Node next;
    }

    private int size;

    private int capacity;

    private Map<Integer, Node> indexMap = new HashMap<>();

    public Solution_146_LRU缓存(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 更新
        // 返回
        if (indexMap.containsKey(key)) {
            return indexMap.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // 更新值 or 新增
        // 如果超出
        // 更新
    }
}
