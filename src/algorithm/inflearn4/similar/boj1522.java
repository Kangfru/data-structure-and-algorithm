package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int aCount = s.length() - s.replace("a", "").length();
        int n = s.length();
        int min = Integer.MAX_VALUE;
        int bCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (s.charAt(i) == 'b') bCount++;
        }
        min = bCount;

        for (int i = 1; i < n; i++) {
            char out = s.charAt(i - 1);
            char in = s.charAt((i + aCount - 1) % n);
            if (in == 'b') bCount++;
            if (out == 'b') bCount--;
            min = Math.min(bCount, min);
        }
        System.out.println(min);
    }

}
