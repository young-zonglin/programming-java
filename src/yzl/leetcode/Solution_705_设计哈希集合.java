package yzl.leetcode;

public class Solution_705_设计哈希集合 {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(3));
        System.out.println(set.contains(1));
        set.remove(1);
        System.out.println(set.contains(1));
    }
}

class MyHashSet {
    private final boolean[] store;

    public MyHashSet() {
        store = new boolean[1000001];
    }

    public void add(int key) {
        store[key] = true;
    }

    public void remove(int key) {
        store[key] = false;
    }

    public boolean contains(int key) {
        return store[key];
    }
}
