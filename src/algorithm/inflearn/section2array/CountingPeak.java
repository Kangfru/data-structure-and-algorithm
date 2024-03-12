package algorithm.inflearn.section2array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingPeak {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isPeak(maps, i, j)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isPeak(int[][] maps, int i, int j) {
        // 4 방향을 확인
        if (maps[i][j] <= maps[i - 1][j]) return false;
        if (maps[i][j] <= maps[i + 1][j]) return false;
        if (maps[i][j] <= maps[i][j - 1]) return false;
        return maps[i][j] > maps[i][j + 1];
    }

}
