package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj1966 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            Queue<int[]> printQueue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int documents = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            // 인덱스(indexed, 중요도 순으로 배열
            for (int j = 0; j < documents; j++) {
                printQueue.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 1;
            while (!printQueue.isEmpty()) {
                int[] current = printQueue.poll();
                boolean hasHigherPriority = !printQueue.isEmpty()
                        && current[1] < Collections.max(printQueue, Comparator.comparingInt(doc -> doc[1]))[1];
                if (hasHigherPriority) {
                    printQueue.add(current);
                } else {
                    if (current[0] == target) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                }
            }
        }
    }

}

