package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class boj5430 {
    static final String[] DIR = {"FORWARD", "REVERSE"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            solve(br);
        }
    }

    static void solve(BufferedReader br) throws Exception {
        String operations = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String array = br.readLine();
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(array.substring(1, array.length() - 1), ",");
        for (int j = 0; j < n; j++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }
        int dirIndex = 0;
        String currentDir = DIR[dirIndex];

        for (int j = 0; j < operations.length(); j++) {
            char operation = operations.charAt(j);
            if (operation == 'R') {
                dirIndex = (dirIndex + 1) % 2;
                currentDir = DIR[dirIndex];
            } else {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }

                if (currentDir.equals(DIR[0])) {
                    // forward
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        // 끝났을 때의 방향이 forward 면 앞에서부터 배열 reverse면 뒤에서부터 배열
        StringJoiner sj = new StringJoiner("," , "[", "]");
        if (currentDir.equals(DIR[0])) {
            while (!deque.isEmpty()) {
                sj.add(deque.pollFirst().toString());
            }
        } else {
            while (!deque.isEmpty()) {
                sj.add(deque.pollLast().toString());
            }
        }
        System.out.println(sj);
    }

}
