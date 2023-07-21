package algorithm.book;

import java.util.Scanner;

// 백준 온라인 저지 11720번
public class question001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (char c : cNum) {
            sum += c - '0';
        }
        System.out.print(sum);
    }

}
