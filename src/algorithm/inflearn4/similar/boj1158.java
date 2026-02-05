package algorithm.inflearn4.similar;

import java.util.*;

public class boj1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int count = 1;
        StringJoiner sj = new StringJoiner(", " , "<", ">");
        while (!queue.isEmpty()) {
            if (count < k) {
                int poll = queue.poll();
                queue.add(poll);
                count++;
            } else if (count == k) {
                sj.add(queue.poll().toString());
                count = 1;
            }
        }

        System.out.println(sj);
    }

}

