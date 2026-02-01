package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 10986과 같은 패턴으로 합이 K인 경우의 수를 찾는다.
 */
public class boj2015 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        long sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            count += map.getOrDefault(sum - target, 0L);
            map.merge(sum, 1L, Long::sum);
        }
        System.out.println(count);
    }

}
