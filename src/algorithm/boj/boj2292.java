package algorithm.boj;

import java.util.Scanner;

public class boj2292 {

    private void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int current = 1;
        int result = 1;
        for (int i = 1; i < N; i++) {
            current = current + 6 * i;
            if (N <= current) {
                result += i;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        new boj2292().solution();
    }

}
