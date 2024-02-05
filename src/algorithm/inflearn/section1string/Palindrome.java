package algorithm.inflearn.section1string;

import java.util.Scanner;

public class Palindrome {

    public boolean solution(String target) {
        int start = 0;
        int end = target.length() - 1;
        char[] chars = target.toLowerCase().toCharArray();
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean solution2(String target) {
        int len = target.length();
        String upperTarget = target.toUpperCase();
        for (int i = 0; i < len / 2; i++) {
            if (upperTarget.charAt(i) != upperTarget.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean solution3(String target) {
        String temp = new StringBuilder(target).reverse().toString();
        return temp.equals(target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        Palindrome p = new Palindrome();
        if (p.solution3(target)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

}
