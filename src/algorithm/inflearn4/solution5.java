package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj10986
 */
public class solution5 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] numbers = new long[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[] count = new long[M];
        count[0] = 1;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numbers[i];
            int remainder = (int)(sum % M);
            count[remainder]++;
        }
        long answer = 0;
        for (int i = 0; i < M; i++) {
            answer += count[i] * (count[i] - 1) / 2;
        }
        System.out.println(answer);
    }

}
