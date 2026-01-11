package algorithm.inflearn3.queueandstack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        // 1. 짝수 여야함.
        // 2. 여는게 먼저
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') ||
                        (c == '}' && open != '{') ||
                        (c == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
