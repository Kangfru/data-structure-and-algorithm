package algorithm.inflearn4;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * boj11286
 */
public class solution14 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer x) -> Math.abs(x))
                .thenComparingInt(x -> x));

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());

            if (current == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(String.format("%d\n", pq.poll()));
                }
            } else {
                pq.add(current);
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
