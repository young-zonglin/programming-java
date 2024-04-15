package yzl.leetcode;

public class Solution_706_设计哈希映射_easy {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(3, 20);
        System.out.println(map.get(3));
        map.remove(3);
        System.out.println(map.get(3));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class MyHashMap {
    private final Integer[] store;

    public MyHashMap() {
        store = new Integer[1000001];
    }

    public void put(int key, int value) {
        store[key] = value;
    }

    public int get(int key) {
        Integer value = store[key];
        if (value == null) return -1;
        return value;
    }

    public void remove(int key) {
        store[key] = null;
    }
}