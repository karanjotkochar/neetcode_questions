import java.util.ArrayList;

public class q37_LRUCache_v1 {
    // brute force -- using arraylist
    // time = o(n) for get/put and space = o(n)
    private ArrayList<int[]> cache;
    private int capacity;
    public static void main(String[] args) {
    }

    public q37_LRUCache_v1(int capacity) {
        this.cache = new ArrayList<>();
        this.capacity = capacity;
    }
    public int get(int key) {

        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] temp = cache.remove(i);       // remove
                cache.add(temp);                    // make it MRU (most recently used)
                return temp[1];                     // since temp has the (key, value), so 1th index
            }
        }
        return -1;
    }
    public void put(int key, int value) {

        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {              // value already exists
                int[] temp = cache.remove(i);          // remove
                temp[1] = value;                       // update the value
                cache.add(temp);                       // make it MRU (most recently used)
                return;
            }
        }

        if (capacity == cache.size()) {                 // arraylist capacity full
            cache.remove(0);
        }
        cache.add(new int[]{key, value});               // add at the end
    }
}