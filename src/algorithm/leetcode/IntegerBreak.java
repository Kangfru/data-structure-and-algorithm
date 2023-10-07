package algorithm.leetcode;

public class IntegerBreak {

    public static int integerBreak(int n) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        integerBreak(10);
    }

}
