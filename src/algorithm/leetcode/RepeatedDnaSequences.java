package algorithm.leetcode;

import java.util.*;

public class RepeatedDnaSequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedDnaList = new ArrayList<>();
        Map<String, Integer> sequenceCheckMap = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subsequence = s.substring(i, i + 10);
            if (!sequenceCheckMap.containsKey(subsequence)) {
                sequenceCheckMap.put(subsequence, 1);
            } else {
                int count = sequenceCheckMap.get(subsequence) + 1;
                sequenceCheckMap.put(subsequence, count);
                if (count == 2) repeatedDnaList.add(subsequence);
            }
        }
        return repeatedDnaList;
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAAAAAAAA");
    }

}
