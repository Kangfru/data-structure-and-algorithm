package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj 1940
 */
public class solution7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] materials = new int[n];
        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materials);
        int count = 0, left = 0, right = n - 1;
        while (left < right) {
            int currentSum = materials[left] + materials[right];
            if (currentSum == m) {
                count++;
                right--;
            } else if (currentSum > m) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(count);
    }

}
