package algorithm.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 각 구간의 길이 및 제한 속도
        int N = Integer.parseInt(st.nextToken()); // 실제 테스트한 구간의 길이 및 제한 속도
        int[] area = new int [101];
        int sector = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int expectedLength = Integer.parseInt(st.nextToken());
            sector += expectedLength;
            int limit = Integer.parseInt(st.nextToken());
            for (int j = sector - expectedLength; j < sector; j++) {
                if (j == 101) break;
                area[j] = limit;
            }
        }

        int max = Integer.MIN_VALUE;
        sector = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int actualLength = Integer.parseInt(st.nextToken());
            sector += actualLength;
            int actualVelocity = Integer.parseInt(st.nextToken());
            for (int j = sector - actualLength; j < sector; j++) {
                if (j == 101) break;
                max = Math.max(max, actualVelocity - area[j]);
            }
        }
        if (max < 0) max = 0;
        System.out.println(max);
    }

}
