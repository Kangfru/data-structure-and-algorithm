package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2539 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temperatures = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            if (!st2.hasMoreTokens()) {
                st2 = new StringTokenizer(br.readLine());
            }
            temperatures[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temperatures[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            sum = sum - temperatures[i-k] + temperatures[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);

    }
}