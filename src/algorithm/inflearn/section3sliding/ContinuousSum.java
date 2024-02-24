package algorithm.inflearn.section3sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // N 개의 수
        int m = Integer.parseInt(st.nextToken()); // 합이 될 target
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 슬라이딩 윈도우의 크기 -> n - 1 까지.
        int answer = 0;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > m) {
                sum -= arr[start++];
            }
            if (sum == m) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
