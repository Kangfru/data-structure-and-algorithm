package algorithm.leetcode;

import java.util.*;

class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            if (countMap.containsKey(n)) {
                countMap.computeIfPresent(n, (key, value) -> ++value);
            } else {
                countMap.put(n, 1);
            }
        }
        for (Integer n : countMap.keySet()) {
            if (countMap.get(n) > nums.length / 3) {
                result.add(n);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

}
