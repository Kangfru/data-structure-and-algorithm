package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private List<Integer> listOfNumbers;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.listOfNumbers = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        listOfNumbers.add(val);
        map.put(val, listOfNumbers.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.remove(val);
        int lastVal = listOfNumbers.remove(listOfNumbers.size() - 1);
        if (lastVal != val) {
            listOfNumbers.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    public int getRandom() {
        int randomNumber = random.nextInt(listOfNumbers.size());
        return listOfNumbers.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
