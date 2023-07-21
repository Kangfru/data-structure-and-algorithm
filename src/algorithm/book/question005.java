package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10986
public class question005 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberCount = Integer.parseInt(tokenizer.nextToken());
        int divideNumber = Integer.parseInt(tokenizer.nextToken());

        long[] sum = new long[numberCount + 1];
        long[] count = new long[divideNumber];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= numberCount; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(tokenizer.nextToken());
        }
        long answer = 0;
        for (int i = 1; i <= numberCount; i++) {
            sum[i] %= divideNumber;
            if (sum[i] == 0) answer++;
            count[(int) sum[i]]++;
        }
        for (int i = 0; i < divideNumber; i++) {
            if (count[i] > 1) {
                answer += count[i] * (count[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }

}
