package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1940
public class question007 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        int target = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = n - 1;
        int count = 0;
        while (startIndex < endIndex) {
            int currentSum = arr[startIndex] + arr[endIndex];
            if (currentSum == target) {
                count++;
                startIndex++;
                endIndex--;
            } else if (currentSum > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        new question007().solution();
    }

}
