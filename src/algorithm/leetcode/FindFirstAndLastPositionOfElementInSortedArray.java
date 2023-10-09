package algorithm.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    private int binarySearch(int[] nums, int target, boolean isFirst) {
        int returnIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target){
                returnIndex = mid;
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return returnIndex;
    }

}
