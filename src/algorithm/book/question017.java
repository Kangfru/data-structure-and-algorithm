package algorithm.book;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// boj1427
public class question017 {

    private void solution() {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        Integer[] sorted = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            sorted[i] = Integer.parseInt(N.substring(i, i+1));
        }
        Arrays.sort(sorted, Collections.reverseOrder());
        for (int j : sorted) {
            System.out.printf("%d", j);
        }
    }

    public static void main(String[] args) {
        new question017().solution();
    }

}
