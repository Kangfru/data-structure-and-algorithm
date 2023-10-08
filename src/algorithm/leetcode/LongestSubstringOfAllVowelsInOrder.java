package algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringOfAllVowelsInOrder {

//    public static int longestBeautifulSubstring(String word) {
//        Deque<Character> deque = new LinkedList<>();
//        int max = Integer.MIN_VALUE;
//        for (char c : word.toCharArray()) {
//            // queue가 비었고 a 부터 시작이면 queue 넎기
//            if (c == 'a') {
//                if (deque.isEmpty()) {
//                    deque.add(c);
//                } else if (deque.peekLast() == 'a') {
//                    deque.addLast(c);
//                } else {
//                    deque.clear();
//                    deque.add(c);
//                }
//            } else if (c == 'e') {
//                if (deque.isEmpty()) continue;
//                if (deque.peekLast() == 'a' || deque.peekLast() == 'e') {
//                    deque.addLast(c);
//                } else {
//                    deque.clear();
//                }
//            } else if (c == 'i') {
//                if (deque.isEmpty()) continue;
//                if (deque.peekLast() == 'e' || deque.peekLast() == 'i') {
//                    deque.addLast(c);
//                } else {
//                    deque.clear();
//                }
//            } else if (c == 'o') {
//                if (deque.isEmpty()) continue;
//                if (deque.peekLast() == 'i' || deque.peekLast() == 'o') {
//                    deque.addLast(c);
//                } else {
//                    deque.clear();
//                }
//            } else {
//                if (deque.isEmpty()) continue;
//                if (deque.peekLast() == 'o' || deque.peekLast() == 'u') {
//                    deque.addLast(c);
//                    max = Math.max(max, deque.size());
//                } else {
//                    deque.clear();
//                }
//            }
//        }
//        return max;
//    }

    public static int longestBeautifulSubstring(String word) {
        // char 계산 버전
        int max = 0;
        int count = 1;
        int currentLength = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                currentLength++;
            } else if (word.charAt(i-1) < word.charAt(i)) {
                currentLength++;
                count++;
            } else {
                currentLength = 1;
                count = 1;
            }
            if (count == 5) max = Math.max(max, currentLength);
        }
        return max;
    }

    public static void main(String[] args) {
        longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
    }
}
