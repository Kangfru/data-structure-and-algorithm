package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class question003 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] readLine = bufferedReader.readLine().split(" ");
        int count = Integer.parseInt(readLine[0]);
        int queryCount = Integer.parseInt(readLine[1]);

        // 합배열 생성 및 넣기
        long[] sumArray = new long[count + 1];
        readLine = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= count; i++) {
            sumArray[i] = sumArray[i - 1] + Long.parseLong(readLine[i - 1]);
        }
        for (int i = 0; i < queryCount; i++) {
            readLine = bufferedReader.readLine().split(" ");
            System.out.println(sumArray[Integer.parseInt(readLine[1])] - sumArray[Integer.parseInt(readLine[0]) - 1]);
        }
    }
}
