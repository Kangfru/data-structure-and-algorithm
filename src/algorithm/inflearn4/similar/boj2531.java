package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2531 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int uniqueCount = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            count[belt[i]]++;
            if (count[belt[i]] == 1) {
                uniqueCount++;
            }
        }
        max = uniqueCount;
        if (count[c] == 0) max++;
        for (int i = 1; i < n; i++) {
            int out = belt[i - 1];
            int in = belt[(i + k - 1) % n];

            count[out]--;
            if (count[out] == 0) uniqueCount--;
            count[in]++;
            if (count[in] == 1) uniqueCount++;
            int bonus = (count[c] == 0) ? 1 : 0;

            max = Math.max(max, uniqueCount + bonus);
        }
        System.out.println(max);
    }

}

