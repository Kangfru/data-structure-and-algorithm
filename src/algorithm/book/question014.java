package algorithm.book;

import java.io.*;
import java.util.PriorityQueue;

// boj 11286
public class question014 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if (num1 == num2) {
                return o1 > o2 ? 1 : -1;
            } else {
                return num1 - num2;
            }
        });

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current == 0) {
                if (pq.size() == 0) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(current);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new question014().solution();
    }

}
