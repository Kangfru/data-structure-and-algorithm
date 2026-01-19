package algorithm.inflearn3.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int answer = 1;
        int currentCount = 1;
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == before + 1) {
                currentCount++;
                answer = Math.max(answer, currentCount);
            } else if (nums[i] == before) {
                // do nothing
            } else {
                answer = Math.max(answer, currentCount);
                currentCount = 1;
            }
            before = nums[i];
        }

        return answer;
    }

    public int longestConsecutiveWithHashSet(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        // 1. 모든 숫자를 HashSet에 추가
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // 2. 세트를 순회하며 연속된 수열 찾기
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 시작점부터 하나씩 큰 숫자가 있는지 확인
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2};
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        l.longestConsecutive(nums);
    }

}
