package algorithm;

import java.util.Scanner;

// 백준 온라인 저지 1546번
public class question002 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] classes = new int[n];
        long sum = 0;
        long max = 0;
        for (int i = 0; i < classes.length; i++) {
            classes[i] = sc.nextInt();
            sum += classes[i];
            if (max < classes[i]) max = classes[i];
        }

        System.out.println(sum * 100.0 / n / max);


    }

}
