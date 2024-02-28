package algorithm.inflearn.section2array;

import java.io.*;
import java.util.StringTokenizer;

public class PrintLargeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int before = Integer.parseInt(st.nextToken());
        int current = -1;
        bw.write(before + " ");
        for (int i = 1; i < n; i++) {
            current = Integer.parseInt(st.nextToken());
            if (current > before) {
                bw.write(current + " ");
            }
            before = current;
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
