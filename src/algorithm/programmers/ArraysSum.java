package algorithm.programmers;

// 프로그래머스 연속된 부분 수열의 합
public class ArraysSum {

    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int size = sequence.length;
        int ans1 = 0;
        int ans2 = 0;
        for (; right < sequence.length; right++) {
            currentSum += sequence[right];
            while (currentSum > k) {
                currentSum -= sequence[left];
                left++;
            }
            if(currentSum == k) {
                if(size > right-left) {
                    size = right-left;
                    ans1 = left;
                    ans2 = right;
                }
                else if(size == right-left) {
                    ans1 = Math.min(ans1, left);
                    ans2 = Math.min(ans2, right);
                }
            }
        }
        return new int[]{ans1, ans2};
    }


}
