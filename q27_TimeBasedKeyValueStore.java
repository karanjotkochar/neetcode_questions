import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q27_TimeBasedKeyValueStore {
    public static void main(String[] args) {

    }
}

class TimeMap {
    // brute force
    // time = o(1) or o(n) and space = o(m * n)
    private Map<String , Map<Integer, List<String>> > keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key)) {
            keyStore.put(key, new HashMap<>());
        }
        if (!keyStore.get(key).containsKey(timestamp)) {
            keyStore.get(key).put(timestamp, new ArrayList<>());
        }
        keyStore.get(key).get(timestamp).add(value);
    }

    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key))
            return "";

        int seen = 0;
        for (int time: keyStore.get(key).keySet()) {
            if (time <= timestamp) {
                seen = Math.max(seen, time);
            }
        }

        if (seen == 0)
            return "";
                                                                // keyStore.get(key).get(seen).size() --> gives you the size of values at timestamp
        int back = keyStore.get(key).get(seen).size() - 1;      // keyStore.get(key).get(seen).size()-1 --> gives you the last element
        return keyStore.get(key).get(seen).get(back);
    }
}

class TimeMap2 {
    // binary search
    // time = o(1) or o(logn) and space = o(m * n)
    private Map<String , List<Pair<Integer, String>> > keyStore;
    public TimeMap2() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {

        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

}