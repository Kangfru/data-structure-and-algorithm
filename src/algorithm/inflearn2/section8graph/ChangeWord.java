package algorithm.inflearn2.section8graph;

import java.util.*;

public class ChangeWord {

    //두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
    //
    //1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
    //2. words에 있는 단어로만 변환할 수 있습니다.
    //예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
    //
    //두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //각 단어는 알파벳 소문자로만 이루어져 있습니다.
    //각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
    //words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
    //begin과 target은 같지 않습니다.
    //변환할 수 없는 경우에는 0를 return 합니다.

    public int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(word -> word.equals(target))) {
            return 0;
        }
        Set<String> used = new HashSet<>();

        // DFS
        Stack<Word> stack = new Stack<>();
        stack.add(new Word(begin, 0));

        while (!stack.isEmpty()) {
            Word now = stack.pop();
            if (now.word.equals(target)) {
                return now.depth;
            }
            for (String word : words) {
                // 바꿀 수 있는 단어만 stack 에 적재
                // 한글자만 다른 단어 && 사용하지 않은 단어
                if (!changeable(now.word, word)) continue;
                if (used.contains(word)) continue;
                stack.push(new Word(word, now.depth + 1));
                used.add(word);
            }
        }

        return 0;
    }

    public int solution2(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(word -> word.equals(target))) {
            return 0;
        }
        Set<String> used = new HashSet<>();
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word now = queue.poll();
            if (now.word.equals(target)) {
                return now.depth;
            }
            for (String word : words) {
                if (!changeable(now.word, word)) continue;
                if (used.contains(word)) continue;
                queue.add(new Word(word, now.depth + 1));
                used.add(word);
            }
        }
        return 0;
    }

    private boolean changeable(String word, String word1) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word1.charAt(i)) count++;
        }
        return count == 1;
    }

    class Word {
        String word;
        int depth;
        public Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }


}