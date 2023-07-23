package algorithm.book;

import java.io.*;
import java.util.Stack;

// boj 1874
public class question011 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            if (num <= target) {
                while (num <= target) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int current = stack.pop();
                if (current > target)  {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
                sb.append("-\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new question011().solution();
    }

}
