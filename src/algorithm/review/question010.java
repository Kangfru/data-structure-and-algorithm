package algorithm.review;

import java.io.*;
import java.util.*;

// boj 11003
public class question010 {

    // N개의 수 A1, A2, ..., AN과 L이 주어진다.
    // Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
    // 슬라이딩 윈도우 내에서 가장 낮은 값

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 우선순위큐 이용 시
        for (int i = 0; i < count; i++) {
            pq.offer(new Node(i, Integer.parseInt(st.nextToken())));
            while (pq.peek().index <= i - windowSize) pq.poll();
            bw.write(pq.peek().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
        // 우선순위큐, 데크 등을 사용가능
    }

    private void solutionDeque() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            int current = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > current) deque.removeLast();
            deque.addLast(new Node(i, current));
//            if (deque.size() > windowSize) deque.removeFirst();
            if (deque.getFirst().index <= i - windowSize) deque.removeFirst();
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new question010().solutionDeque();
    }

    public static class Node implements Comparable<Node> {
        private final int index;

        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

}
