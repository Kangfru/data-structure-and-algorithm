package algorithm.inflearn3.queueandstack;

import java.util.Stack;

public class DailyTemperatures {

    // 10^5 -> O(n^2) 면 시간 복잡도 통과 실패함.
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // 인덱스저장

        for (int i = 0; i < temperatures.length; i++) {
            // 현재 온도가 스택 맨 위의 인덱스에 해당하는 온도보다 높으면
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop(); // 인덱스를 꺼냄
                answers[index] = i - index; // 날짜 차이 계산
            }
            stack.push(i); // 현재 인덱스를 스택에 넣음
        }

        return answers;
    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] input = new int[]{73,74,75,71,69,72,76,73};
        for (int temp : d.dailyTemperatures(input)) {
            System.out.println(temp);
        }
    }
}
