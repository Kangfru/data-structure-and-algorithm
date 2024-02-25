package algorithm.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class SuperBugs {

    public static void main(String[] args) throws IOException {
        // Divide and conquer 로 재 개발 필요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal k = new BigDecimal(st.nextToken()); // 초기 바이러스 수
        BigDecimal p = new BigDecimal(st.nextToken()); // 증가율
        BigDecimal n = new BigDecimal(st.nextToken()); // 초.

        //  1초에 p ^ 10 n 초에 k * p^10*n 승
        BigDecimal result = k.multiply(p.pow(BigDecimal.TEN.multiply(n).intValue())).remainder(BigDecimal.valueOf(1000000007));
        System.out.println(result);
    }

}
