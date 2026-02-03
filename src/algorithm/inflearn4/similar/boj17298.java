package algorithm.inflearn4.similar;

import java.io.*;
import java.util.*;

public class boj17298 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }

}

