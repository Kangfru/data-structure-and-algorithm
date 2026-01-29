package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj 11720
 */
public class solution1 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += numbers.charAt(i) - '0';
        }

        System.out.println(answer);

    }

}
