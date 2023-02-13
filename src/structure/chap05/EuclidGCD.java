package structure.chap05;

import java.util.Scanner;

public class EuclidGCD {

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    static int gcdArray(int[] x, int start, int no) {
        if (no == 1)
            return x[start];
        else if (no == 2)
            return gcd(x[start], x[start + 1]);
        else
            return gcd(x[start], gcdArray(x, start + 1, no - 1));
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수 몇 개의 최대 공약수를 구할까요?：");
        int num;
        do {
            num = stdIn.nextInt();
        } while (num <= 1);

        int[] x = new int[num]; // 길이 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        System.out.println("최대 공약수는 " + gcdArray(x, 0, num) + "입니다.");
    }

}
