package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // bruteForce way
    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numSubtractMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int subtract = target - nums[i];
            if (numSubtractMap.containsKey(subtract)) {
                return new int[]{numSubtractMap.get(subtract), i};
            }
            numSubtractMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
