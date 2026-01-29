package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj 1546
 */
public class solution2 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int classes = Integer.parseInt(br.readLine());
        int[] scores = new int[classes];
        int total = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < classes; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            total += scores[i];
            max = Math.max(scores[i], max);
        }

        System.out.println((double) total * 100 / max / classes);

    }

}
