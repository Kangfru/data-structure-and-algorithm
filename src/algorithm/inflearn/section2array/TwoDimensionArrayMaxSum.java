package algorithm.inflearn.section2array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDimensionArrayMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arrays = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arrays[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = calculateMaxSum(n, arrays);
        System.out.println(max);
    }

    private static int calculateMaxSum(int n, int[][] arrays) {
        int max = Integer.MIN_VALUE;
        int rowSum = 0;
        int colSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += arrays[i][j];
                colSum += arrays[j][i];
            }
            max = Math.max(max, Math.max(rowSum, colSum));
            rowSum = 0;
            colSum = 0;
        }
        int crossSum1 = 0;
        int crossSum2 = 0;
        for (int i = 0; i < n; i++) {
            crossSum1 += arrays[i][i];
            crossSum2 += arrays[i][n - i - 1];
        }
        max = Math.max(max, Math.max(crossSum1, crossSum2));
        return max;
    }

}
