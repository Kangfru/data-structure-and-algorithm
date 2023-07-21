package algorithm.book;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class question010 {

    // -> O(n^2) : 시간초과
//    public void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int size = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[] answer = new int[n];
//        for (int i = 0; i < n; i++) {
//            int startIndex = i - size + 1;
//            int min = Integer.MAX_VALUE;
//            for (int j = startIndex; j <= i; j++) {
//                if (j < 0) continue;
//                if (arr[j] < min) min = arr[j];
//            }
//            answer[i] = min;
//        }
//
//        for (int ans : answer) {
//            System.out.print(ans + " ");
//        }
//        br.close();
//    }

    // -> O(nlogn) : 시간초과
//    public void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int size = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            pq.offer(new Node(Integer.parseInt(st.nextToken()), i));
//            while (pq.peek().index <= i - size) pq.poll();
//            bw.write(pq.peek().value + " ");
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }

//    public void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int size = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//
//        Deque<Node> deque = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            int current = Integer.parseInt(st.nextToken());
//            while (!deque.isEmpty() && deque.getLast().value > current) deque.removeLast();
//            deque.addLast(new Node(current, i));
//            if (deque.getFirst().index <= i - size) deque.removeFirst();
//            bw.write(deque.getFirst().value + " ");
//        }
//        bw.flush();
//        bw.close();
//        br.close();
//    }

    // 링크드 리스트
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Node> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            while (!linkedList.isEmpty() && linkedList.getLast().value > current) linkedList.removeLast();
            linkedList.addLast(new Node(current, i));
            if (linkedList.getFirst().index <= i - size) linkedList.removeFirst();
            bw.write(linkedList.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Node implements Comparable<Node> {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        new question010().solution();
    }

}
