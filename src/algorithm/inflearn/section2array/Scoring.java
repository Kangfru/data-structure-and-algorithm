package algorithm.inflearn.section2array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Scoring {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int addScore = 0;
        int score = 0;
        while (st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                score += ++addScore;
            } else {
                addScore = 0;
            }
        }
        System.out.println(score);
    }

}
