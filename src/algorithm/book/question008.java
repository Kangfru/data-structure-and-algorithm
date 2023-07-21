package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// boj 1253
public class question008 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int leftIndex = 0;
            int rightIndex = i - 1;
            while (leftIndex < rightIndex) {
                long currentSum = arr[leftIndex] + arr[rightIndex];
                if (currentSum == arr[i]) {
                    if (leftIndex != i && rightIndex != i) {
                        count++;
                        break;
                    } else if (leftIndex == i){
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                } else if (currentSum < arr[i]) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        new question008().solution();
    }
}
