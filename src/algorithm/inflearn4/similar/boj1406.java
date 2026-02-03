package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj1406 {

    public static void main(String[] args) throws Exception {
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        for (int i = 0; i < init.length(); i++) {
            left.addLast(init.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String operation = br.readLine();
            if (operation.equals("L")) {
                if (!left.isEmpty()) {
                    right.add(left.pollLast());
                }
            } else if (operation.equals("D")) {
                if (!right.isEmpty()) {
                    left.addLast(right.pollLast());
                }
            } else if (operation.contains("P")) {
                left.add(operation.split(" ")[1].toCharArray()[0]);
            } else if (operation.equals("B")) {
                if (!left.isEmpty()) {
                    left.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.pollLast());
        }
        System.out.println(sb);
    }

}

