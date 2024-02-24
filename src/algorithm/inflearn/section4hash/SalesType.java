package algorithm.inflearn.section4hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SalesType {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int[] sales = new int[days];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < days; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }
        int end = size - 1;
        List<Integer> answers = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= end; i++) {
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
        }
        answers.add(map.size());
        for (int i = size; i < days; i++) {
            map.put(sales[i - size], map.get(sales[i - size]) - 1);
            if (map.get(sales[i - size]) == 0) {
                map.remove(sales[i - size]);
            }
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
            answers.add(map.size());
        }
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

}
