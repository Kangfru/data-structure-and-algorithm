package algorithm.inflearn4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * boj 11003
 */
public class solution10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<int []> deque = new ArrayDeque<>(); // index, value 순으로 저장.

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekFirst()[0] <= i - l) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast()[1] >= current) {
                deque.pollLast();
            }

            deque.addLast(new int[]{i, current});
            sb.append(deque.peekFirst()[1]).append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

}
