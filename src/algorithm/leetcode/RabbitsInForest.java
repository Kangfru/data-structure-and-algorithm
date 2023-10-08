package algorithm.leetcode;

import java.util.*;

public class RabbitsInForest {

    public static int numRabbits(int[] answers) {
        int rabbitCount = 0;
        Map<Integer, Integer> checkedList = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                rabbitCount++;
                continue;
            }
            checkedList.put(answers[i], checkedList.getOrDefault(answers[i], 0) + 1);
        }

        for (int key : checkedList.keySet()) {
            int group = key + 1; // 해당 키를 말한 토끼의 추정 수
            int groupCount = checkedList.get(key) / group;
            if (checkedList.get(key) % group != 0) {
                groupCount += 1;
            }
            rabbitCount += group * groupCount;
        }
        return rabbitCount;
    }
    public static void main(String[] args) {
        numRabbits(new int[]{1,1,2});
    }

}
