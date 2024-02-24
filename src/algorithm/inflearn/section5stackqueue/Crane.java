package algorithm.inflearn.section5stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Crane {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = size - 1; j >= 0; j--) {
                if (grid[j][i] != 0) stack.push(grid[j][i]);
            }
            stacks.add(stack);
        }
        Stack<Integer> basket = new Stack<>();
        int playCount = Integer.parseInt(br.readLine());
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            Stack<Integer> selectedLine = stacks.get(current - 1);
            if (!selectedLine.isEmpty()) {
                int popDoll = selectedLine.pop();
                if (!basket.isEmpty()) {
                    if (basket.peek() == popDoll) {
                        while (popDoll == basket.peek()) {
                            popDoll = basket.pop();
                            answer++;
                        }
                    } else {
                        basket.push(popDoll);
                    }
                } else {
                    basket.push(popDoll);
                }
            }
        }
        System.out.println(answer * 2);
    }

}

// 4 3 1