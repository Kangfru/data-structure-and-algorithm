package algorithm.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecretMenu {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int secretCount = Integer.parseInt(st.nextToken());
        int manualCount = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 1 ~ K 이하의 정수
        String secretes = br.readLine();
        String manual = br.readLine();
        System.out.println(manual.contains(secretes) ? "secret" : "normal");
    }

}
