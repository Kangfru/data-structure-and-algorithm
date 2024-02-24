package algorithm.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObstacleRecognition {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] maps = new char[size][size];
        for (int i = 0; i < size; i++) {
            String row = br.readLine();
            for (int j = 0; j < size; j++) {
                maps[i][j] = row.charAt(j);
            }
        }

        List<Integer> answers = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j< size; j++) {
                if (maps[i][j] == '1') {
                    count++;
                    int answer = 0;
                    answer = dfs(i, j, maps, answer);
                    answers.add(answer);
                }
            }
        }

        Collections.sort(answers);
        System.out.println(count);
        for (int answer : answers) {
            System.out.println(answer);
        }

    }
    public static int dfs(int x, int y, char[][] maps, int count) {
        if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length && maps[x][y] == '1') {
            maps[x][y] = '0';
            count++;
            count = dfs(x, y+1, maps, count);
            count = dfs(x, y-1, maps, count);
            count = dfs(x+1, y, maps, count);
            count = dfs(x-1, y, maps, count);
        }
        return count;
    }

}
