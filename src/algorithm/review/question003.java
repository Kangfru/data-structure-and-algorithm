package algorithm.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj 11659
public class question003 {

    private void solution() throws IOException {
        // 수 N 개가 주어졌을 때 i번쨰 수에서 j번쨰 수까지의 합을 구하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int qCount = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long[] sum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < qCount; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            System.out.println(sum[second] - sum[first - 1]);
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        new question003().solution();
    }

}
