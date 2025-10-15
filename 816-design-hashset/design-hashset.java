import java.util.*;

class MyHashSet {
    private final int SIZE = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int i = hash(key);
        if (buckets[i] == null) {
            buckets[i] = new LinkedList<>();
        }
        if (!buckets[i].contains(key)) {
            buckets[i].add(key);
        }
    }

    public void remove(int key) {
        int i = hash(key);
        if (buckets[i] != null) {
            buckets[i].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int i = hash(key);
        return buckets[i] != null && buckets[i].contains(key);
    }
}
