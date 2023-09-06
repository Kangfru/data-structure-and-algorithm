package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// boj 11724
public class question023 {

    boolean[] visited;

    ArrayList<Integer>[] array;

    private void solution() throws IOException {
        // 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visited =  new boolean[count + 1];
        array = new ArrayList[count + 1];
        for (int i = 1; i <= count; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);

        }
        int result = 0;
        for (int i = 1; i < count + 1; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    private void dfs(int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : array[i]) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new question023().solution();
    }

}
