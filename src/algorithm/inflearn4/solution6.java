package algorithm.inflearn4;

import java.util.Scanner;

/**
 * boj2018
 */
public class solution6 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int sum = 1, count = 1, left = 1, right = 1;
        while (right != target) {
            if (sum == target) {
                count++;
                right++;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        System.out.println(count);
    }

}
