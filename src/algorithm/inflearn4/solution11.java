package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * boj1874
 */
public class solution11 {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int current = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            if (current <= target) {
                while (current <= target) {
                    stack.push(current++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int last = stack.pop();
                if (last != target) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

}
