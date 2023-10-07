package algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class TimeBasedKeyValueStore {

    HashMap<String, String> hashMap;
    LinkedList<Integer> list;
    public TimeBasedKeyValueStore() {
        hashMap = new HashMap<>();
        list = new LinkedList<>();
    }

    public void set(String key, String value, int timestamp) {
        hashMap.put(key + timestamp, value);
        list.add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (hashMap.containsKey(key + timestamp)) {
            return hashMap.get(key + timestamp);
        } else {
            int index = list.size() - 1;
            while (index >= 0) {
                String nextKey = key + list.get(index);
                if (timestamp > list.get(index) && hashMap.containsKey(nextKey)) {
                    return hashMap.get(nextKey);
                }
                index--;
            }
            return "";
        }
    }

}
