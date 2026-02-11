package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * boj 1377
 */
public class solution16 {

    public static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i].index - i); // 원래 인덱스 - 정렬 후 인덱스
        }

        System.out.println(max + 1);
    }

}
