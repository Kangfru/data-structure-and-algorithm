package algorithm.book;

import java.io.*;

// boj 10989
public class question022 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 5 자리수가 최대임 (10_000)
        radixSort(arr, 5);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void radixSort(int[] arr, int digits) {
        int[] output = new int[arr.length];
        int currentDigit = 1;
        int count = 0;
        while (count != digits) {
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / currentDigit) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / currentDigit % 10)] - 1] = arr[i];
                bucket[(arr[i] / currentDigit) % 10]--;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            currentDigit *= 10;
            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        new question022().solution();
    }

}
