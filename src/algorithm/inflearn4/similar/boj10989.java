package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] counting = new int[10001];
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            counting[current]++;
        }
        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < counting[i]; j++) {
                bw.write(i + "\n");
            }

        }
        bw.flush();
        bw.close();
    }
}

