package algorithm.leetcode;

import java.util.Random;

public class RandomPickWithWeight {

    int[] weightedSum;
    int total;

    public RandomPickWithWeight(int[] w) {
        int sum = 0;
        weightedSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            this.weightedSum[i] = sum;
        }
        total = sum;
    }

    public int pickIndex() {
        Random random = new Random(total);
        for (int i = 0; i < weightedSum.length; i++) {
            if (weightedSum[i] > random.nextInt()) {
                return weightedSum[i];
            }
        }
        return -1;
    }

}