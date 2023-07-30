package algorithm.book;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// boj 2164
public class question013 {

    public void solution() {

        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll(); // 맨 위에걸 버린다
            queue.add(queue.poll()); // 다음 맨 위에걸 아래에 넣는다/
        }
        System.out.println(queue.poll());

    }

    public static void main(String[] args) {
        new question013().solution();
    }
}
