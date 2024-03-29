package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        long[][] array = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[i][j] = Long.parseLong(tokenizer.nextToken());
            }
        }

        long[][] sum = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + array[i][j];
                System.out.println(sum[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            System.out.println(sum[x2][y2] - sum[x2][y1 - 1] - sum[x1-1][y2] + sum[x1-1][y1-1]);
        }
    }

}
