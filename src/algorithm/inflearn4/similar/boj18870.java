package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            treeSet.add(arr[i]);
        }
        int rank = 0;
        for (int num : treeSet) {
            rankMap.put(num, rank++);
        }
        for (int target : arr) {
            bw.write(rankMap.get(target) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

