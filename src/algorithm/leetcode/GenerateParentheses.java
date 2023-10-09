package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> answers = new ArrayList<>();
        generate(answers, n, 0, 0, "");
        return answers;
    }

    public void generate(List<String> answers, int n, int countOpen, int countClose, String currentString) {

        // termination check
        if (countOpen == n && countClose == n) {
            answers.add(currentString);
            return;
        }

        // recursive
        if (countOpen < n) {
            generate(answers, n, countOpen + 1, countClose, currentString + "(");
        }
        if (countOpen > countClose) {
            generate(answers, n, countOpen, countClose + 1, currentString + ")");
        }
    }

}
