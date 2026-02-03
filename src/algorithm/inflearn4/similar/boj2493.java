package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
//			if (stack.isEmpty()) {
//				stack.push(i);
//				result[i] = 0;
//			} else {
//				if (arr[stack.peek()] < arr[i]) {
//					while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
//						stack.pop();
//					}
//					if (stack.isEmpty()) {
//						stack.push(i);
//						result[i] = 0;
//					} else {
//						result[i] = stack.peek() + 1;
//						stack.push(i);
//					}
//				} else {
//					result[i] = stack.peek() + 1;
//					stack.push(i);
//				}
//			}
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}

