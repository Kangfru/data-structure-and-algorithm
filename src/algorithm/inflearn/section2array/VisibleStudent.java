package algorithm.inflearn.section2array;

import java.io.*;
import java.util.StringTokenizer;

public class VisibleStudent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int currentLargestHeight = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (currentLargestHeight < arr[i]) {
                count++;
                currentLargestHeight = arr[i];
            }
        }
        System.out.println(count);
        br.close();
    }

}
