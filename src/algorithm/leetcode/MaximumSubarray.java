package algorithm.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int answer = Integer.MIN_VALUE;
        for (int j : dp) {
            answer = Math.max(answer, j);
        }
        return answer;
    }

}
