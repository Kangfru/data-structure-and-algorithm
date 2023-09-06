package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj 1260
public class question026 {

    boolean[] visited;
    ArrayList<Integer>[] arrays;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        visited = new boolean[nodeCount + 1];
        arrays = new ArrayList[nodeCount + 1];

        for (int i = 1; i <= nodeCount; i++) {
            arrays[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrays[s].add(e);
            arrays[e].add(s);
        }
        for (int i = 1; i <= nodeCount; i++) {
            // 번호 작은 것먼저 -> 정렬 필요
            Collections.sort(arrays[i]);
        }
        // DFS 수행
        dfs(startNode);
        System.out.println();

        // 방문배열 초기화
        visited = new boolean[nodeCount + 1];
        // BFS 수행
        bfs(startNode);

    }

    private void dfs(int start) {
        if (visited[start]) return;
        System.out.print(start + " ");
        visited[start] = true;
        for (int s : arrays[start]) {
            if (!visited[s]) {
                dfs(s);
            }
        }
    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int s : arrays[current]) {
                if (!visited[s]) {
                    System.out.print(s + " ");
                    queue.add(s);
                    visited[s] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new question026().solution();
    }

}
