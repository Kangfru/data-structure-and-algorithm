package algorithm.book;

import java.util.Scanner;

// 백준 2018
public class question006 {

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;
        while (endIndex != n) {
            if (sum == n) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum > n) {
                sum -= startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        new question006().solution();
    }
}
