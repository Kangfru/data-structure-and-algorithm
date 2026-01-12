package algorithm.inflearn3.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSumWithHash {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.putIfAbsent(nums[i], i);
        }
        return new int[]{map.get(nums.length - 2), map.get(nums.length - 1)};
    }

}
