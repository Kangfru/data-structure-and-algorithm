package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj1021 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < k; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = deque.indexOf(target);
            int rightIndex = deque.size() - index;
            if (index >= rightIndex) {
                // 우측이 더 작으므로 우측 회전
                while (!deque.isEmpty() && deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            } else {
                // 좌측 회전
                while (!deque.isEmpty() && deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);

    }

}

