package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj 11399
 * 책의 내용에 맞춰 삽입정렬로 먼저 풀어본다.
 */
public class solution18 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[n];

        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        for (int i = 1; i < n; i++) {
            int target = line[i];
            int j = i - 1;
            while (j >= 0 && target < line[j]) {
                line[j + 1] = line[j];
                j--;
            }
            line[j + 1] = target;
        }

        // 합구하기
        int[] sigma = new int[n];
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += line[i];
            sigma[i] = currentSum;
        }
        System.out.println(Arrays.stream(sigma).sum());
    }

}
